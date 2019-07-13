一、先看下BeanPostProcessor和BeanFactoryPostProcessor的各自的子类以及方法。

    1、 BeanFactoryPostProcessor，是针对整个工厂生产出来的BeanDefinition作出修改或者注册。作用于BeanDefinition时期。从名称可以看出是容器级别的，继承关系如下：



   BeanFactoryPostProcessor和其子类总共二个方法，从其入参就可以看出这二个方法的具体使用，如下：

   postProcessBeanDefinitionRegistry方法，此方法参数是一个BeanDefinitionRegistry，众所周知BeanDefinitionRegistry是用于
beanDefinition注册、修改的。那么此方法在就可以在spring standard initialization后去修改一个beanDefinition、或者新增一个。
这个类有个巨屌的实现类ConfigurationClassPostProcessor，这个类将处理configuration的类中以下注解：@Import、@PropertySource、@ComponentScan、@ImportResource、@Bean methods等。将这些注解涉及到的BeanDifinition注册到BeanDefinitionRegistry中。对ConfigurationClassPostProcessor加载兴趣的查看可以看下此链接；
postProcessBeanFactory方法，也是在实例化之前调用，也是读取bean定义并作出修改，比如属性修改，这个类spring也有一个巨牛的实现类PropertyPlaceholderConfigurer，这类的描述如下：将配置文件中的值注入到我们的代码中！！如数据源信息等。类解释如下：

/**
 *
 * {@link PlaceholderConfigurerSupport} subclass that resolves ${...} placeholders
 * against {@link #setLocation local} {@link #setProperties properties} and/or system properties
 * and environment variables.
 * .....
 */
2、BeanPostProcessor 的作用于bean实例化、初始化前后执行，先看下继承关系。




BeanPostProcessor子类比较多，有4个拓展接口，拢共11个方法，这个11方法描述如下：

BeanPostProcessors是在实例化后，初始化方法执行前、后分别执行2个方法(这里的初始化方法是init-method或者实现了InitializingBean的afterPropertiesSet方法，一般这个玩意用于读取缓存文件，初始化信息等操作)。通过这个类我们可以轻松的自定义受spring管理的bean，就是可以对bean为所欲为！

InstantiationAwareBeanPostProcessor拓展了BeanPostProcessors接口，这个接口也是非常的牛掰，可以在实例化Bean前（调用postProcessBeforeInstantiation方法）、后(postProcessAfterInstantiation)提供扩展的回调接口。
postProcessBeforeInstantiation这个返回值可以用来代替原本该生成的目标对象的实例(比如代理对象)。如果该方法的返回值代替原本该生成的目标对象，后续只有postProcessAfterInitialization方法会调用然后就直接返回了。不会在进行后续操作(可以看下AbstractAutoProxyCreator AOP代理实现）。这个类还是有一个方法：postProcessPropertyValues，这个方法是bean实例化后填充属性的时候使用，
描述如下：

    //这个方法用来在对象实例化前直接返回一个对象（如代理对象）来代替通过内置的实例化流程创建对象；
    @Nullable
    default Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }
    //在对象实例化完毕执行populateBean之前 如果返回false则spring不再对对应的bean实例进行自动依赖注入。
    default boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }
    //这里是在spring处理完默认的成员属性，应用到指定的bean之前进行回调，可以用来检查和修改属性，最终返回的PropertyValues会应用到bean中
    //@Autowired、@Resource等就是根据这个回调来实现最终注入依赖的属性的。
    @Nullable
    default PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }
SmartInstantiationAwareBeanPostProcessor又拓展了InstantiationAwareBeanPostProcessor接口，主要是供spring内部使用，接口方法描述如下：

    /**
     * 用来返回目标对象的类型（比如代理对象通过raw class获取proxy type 用于类型匹配）
     */
    @Nullable
    default Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
    	return null;
    }
    /**
     * 这里提供一个拓展点用来解析获取用来实例化的构造器（比如未通过bean定义构造器以及参数的情况下，会根据这个回调来确定构造器）
     */
    @Nullable
    default Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)throws BeansException {
        return null;
    }
    /**
     * 提前暴露bean引用，解决循环依赖
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
    	return bean;
    }


MergedBeanDefinitionPostProcessor，也是实例化后执行，主要将那些元数据缓存起来以提供后续的postProcessPropertyValues输入注入时获取。

/***
 * 在bean实例化完毕后调用， 缓存一些meta信息提供给后续的injectValue使用
 *／
    void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName);
！


DestructionAwareBeanPostProcessor，是对象销毁的前置回调。


/***
 * 销毁逻辑
 *／ 
    void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException;
    //判断是否需要处理这个对象的销毁
    default boolean requiresDestruction(Object bean) {
        return true;
    }
经过以上简单介绍，可能对这个2个processor有了简单的了解，那么我们下面开始从spring加载流程来看，这么方法在什么时候回调的！

二、processor各个方法在spring容器启动中扮演的角色，spring在加载bean无非将所有需要管理的bean定义、并注册。然后bean实例化、填充bean属性。而processor也是作用在这些步骤前后。

  bean定义注册阶段，BeanDefinition阶段，对于spring工程而言，我们对于需要容器管理的bean无非通过注解、xml等方式实现，比如使用ClassPathBeanDefinitionScanner#doScan可以扫描指定包下面的类注册到容器中等，这里不做过多讨论直接跳过，spring标准初始化后，受管理的bean定义都已经被注册到容器中了，另外插一句就是beanFactory和applicationcontext有一点区别就是beanFactory不会自动收集这些BeanPostProcessor，而applicationcontext会收集这些processor到我们工厂中。(ConfigurableListableBeanFactory#addBeanPostProcessor等)。
我们先看下PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors方法，BeanFactoryPostProcessor以及子类都是在这个方法中回调的。下面我们先看下这个方法吧
    //这个beanFactoryPostProcessors是获取手动注册的BeanFactoryPostProcessors。不是标准化的加载进来的
	// 如：通过ApplicationContextInitializer初始化的BeanFactoryPostProcessors
	public static void invokeBeanFactoryPostProcessors(
			ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {

		// Invoke BeanDefinitionRegistryPostProcessors first, if any.
		//记录处理过的家伙
		Set<String> processedBeans = new HashSet<>();
		//判断是否BeanDefinitionRegistry实例，因为BeanDefinitionRegistry这玩意定义一个bean的
		if (beanFactory instanceof BeanDefinitionRegistry) {
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
			//BeanFactoryPostProcessor集合
			List<BeanFactoryPostProcessor> regularPostProcessors = new LinkedList<>();
			//BeanDefinitionRegistryPostProcessor集合
			List<BeanDefinitionRegistryPostProcessor> registryProcessors = new LinkedList<>();
			//硬编码注册的后置处理，自定义的BeanFactoryPostProcessor处理
	        //第一步01：
			for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
				if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
					BeanDefinitionRegistryPostProcessor registryProcessor =
							(BeanDefinitionRegistryPostProcessor) postProcessor;
					//执行BeanDefinitionRegistryPostProcessor的方法
					registryProcessor.postProcessBeanDefinitionRegistry(registry);
					registryProcessors.add(registryProcessor);
				} else {
					regularPostProcessors.add(postProcessor);
				}
			}
	 
			// Do not initialize FactoryBeans here: We need to leave all regular beans
			// uninitialized to let the bean factory post-processors apply to them!
			// Separate between BeanDefinitionRegistryPostProcessors that implement
			// PriorityOrdered, Ordered, and the rest.
			List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();
	          
	        //第二步02：首先获取优先最高的Processors
			// First, invoke the BeanDefinitionRegistryPostProcessors that implement PriorityOrdered.
			String[] postProcessorNames =
					beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();
	        //第三步03：获取优先次之的Processors
			// Next, invoke the BeanDefinitionRegistryPostProcessors that implement Ordered.
			postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();
	        //第四步04：最后获取优先级低的Processors
			// Finally, invoke all other BeanDefinitionRegistryPostProcessors until no further ones appear.
			boolean reiterate = true;
			while (reiterate) {
				reiterate = false;
				postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
				for (String ppName : postProcessorNames) {
					if (!processedBeans.contains(ppName)) {
						currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
						processedBeans.add(ppName);
						reiterate = true;
					}
				}
				sortPostProcessors(currentRegistryProcessors, beanFactory);
				registryProcessors.addAll(currentRegistryProcessors);
				invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
				currentRegistryProcessors.clear();
			}
	        //第五步05：
			// Now, invoke the postProcessBeanFactory callback of all processors handled so far.
			invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);
			invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
		}else {
			// Invoke factory processors registered with the context instance.
			invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
		}
	     //第六步06
		// Do not initialize FactoryBeans here: We need to leave all regular beans
		// uninitialized to let the bean factory post-processors apply to them!
		String[] postProcessorNames =
				beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);
	 
		// Separate between BeanFactoryPostProcessors that implement PriorityOrdered,
		// Ordered, and the rest.
		List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
		List<String> orderedPostProcessorNames = new ArrayList<>();
		List<String> nonOrderedPostProcessorNames = new ArrayList<>();
		for (String ppName : postProcessorNames) {
			if (processedBeans.contains(ppName)) {
				// skip - already processed in first phase above
			}
			else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
				priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
				orderedPostProcessorNames.add(ppName);
			}
			else {
				nonOrderedPostProcessorNames.add(ppName);
			}
		}
	 
		// First, invoke the BeanFactoryPostProcessors that implement PriorityOrdered.
		sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);
	 
		// Next, invoke the BeanFactoryPostProcessors that implement Ordered.
		List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList<>();
		for (String postProcessorName : orderedPostProcessorNames) {
			orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		sortPostProcessors(orderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);
	 
		// Finally, invoke all other BeanFactoryPostProcessors.
		List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList<>();
		for (String postProcessorName : nonOrderedPostProcessorNames) {
			nonOrderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);
	 
		// Clear cached merged bean definitions since the post-processors might have
		// modified the original metadata, e.g. replacing placeholders in values...
		beanFactory.clearMetadataCache();
	}
这里面我分为了6大步：
第一步：这里其实一般 走不到的，因为beanFactoryPostProcessors是空的，这里的beanFactoryPostProcessors值不是标准化加载过来，而是一些类似于ApplictionContextInitialiazer方法加载processor的。比如:

public class ApplicationContextInitializerDemo implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.addBeanFactoryPostProcessor(
                new ConfigurationWarningsPostProcessor(getChecks()));
    }
}
第二步至第第四步：这里的代码处理逻辑基本一样的，先从BeanFactory#getBeanNamesForType方法中找出所有BeanDefinitionRegistryPostProcessor类型的，然后根据实现类的优先级执行postProcessBeanDefinitionRegistry方法。为什么要getBeanNamesForType3次呢？因为优先级高实现类在执行postProcessBeanDefinitionRegistry方法时可能会定义一个BeanDefinitionRegistryPostProcessor的实现类，
这里我们介绍一个spring对BeanDefinitionRegistryPostProcessor的实现类ConfigurationClassPostProcessor,这个类实现了PriorityOrdered，用于处理打了@Configuration标签的Class。ConfigurationClassParser会对这个类进行解析。会解析以下标签：
处理@PropertySource标签，用来解析属性文件并设置到Environment中。
处理@ComponentScan标签，扫描package下的所有Class并进行解析注册。
处理@Import标签。
处理@ImportResource标签。
处理@Bean标签......
第五步：没什么好说的就是执行BeanDefinitionRegistryPostProcessor的父类方法postProcessBeanFactory。
第六部到最后：收集所有实现了BeanFactoryPostProcessor的类，根据优先级执行postProcessBeanFactory方法，这个时候可能有疑问就是为什么不也查找3次呢？因为参数啊！！！BeanDefinitionRegistryPostProcessor中方法的参数是一个BeanDefinitionRegistry，而BeanFactoryPostProcessor的参数是一个BeanFactory。BeanDefinitionRegistry是干什么的？是BeanDefinition注册、修改。所以人家可以新注册一个BeanDefinition！！！但是你BeanFactory可以么！！！

Bean的实例化前后：
 在实例化、初始化前后我们的BeanPostProcessor都已经被方法registerBeanPostProcessors注册到BeanFactory的子类AbstractBeanFactory集合中.

/** BeanPostProcessors to apply in createBean */
	private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
先看下在实例化前后spring是如何回调的,直接到最终的方法createBean方法，这个方法做了创建bean实例、填充bean实例:

protected Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
			throws BeanCreationException {
		/***
                 * ...代码省略 
                 */
		try {
			//实例化前调用，给BeanPostProcessor（InstantiationAwareBeanPostProcessor）一个机会返回代理来代替真正的实例
			Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
			if (bean != null) {
				return bean;
			}
		}
		/***
                 * ...代码省略 
                 */
		try {
                    //实例化、填充属性、processor回调
			Object beanInstance = doCreateBean(beanName, mbdToUse, args);
			return beanInstance;
		}
                /***
                 * ...代码省略 
                 */	
	}
这个方法有2个方法一个是resolveBeforeInstantiation方法，用于执行InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation，这个方法在上面有过解释，是用来生成一个Bean实例或者代理，不为空则执行完BeanPostProcessor#postProcessAfterInitialization就直接返回了。
另一个方法是AbstractAutowireCapableBeanFactory#doCreateBean，这个方法代码和注释如下：

protected Object doCreateBean(final String beanName, final RootBeanDefinition mbd, final @Nullable Object[] args)
			throws BeanCreationException {
		       /***
                        * ...代码省略 
                        */
                        //bean的实例化代码~~~
	                //执行MergedBeanDefinitionPostProcessor的方法，
			//实例化后调用postProcessMergedBeanDefinition 比如其中一个实现就是将需要注解的元数据 放到Map中供 属性注入时使用
			applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
	               /***
                        * ...代码省略 
                        */   
                        //实例化后调用getEarlyBeanReference 为了避免后期循环依赖 可以在bean初始化完成前 将创建实例的Objectfactory加入工厂
			addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
		// Initialize the bean instance.
		Object exposedObject = bean;
		try {
			//填充bean，可能产生依赖其他bean  则递归
			populateBean(beanName, mbd, instanceWrapper);
			//调用初始化方法 如init-method、实现InitializingBean的类
			exposedObject = initializeBean(beanName, exposedObject, mbd);
		}
	       /***
                * ...代码省略 
                */ 
		return exposedObject;
	}
那么实例化前后方法都调用完毕。

Bean属性填充：主要有2个方法，先看填充属性方法populateBean()：此方法在填充属性之前，如果返回false则不在执行属性填充操作！如果返回true则回调postProcessPropertyValues方法进行属性注入！这里面的缓存的元数据来源上一个MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition的缓存。这个可以去看下AutowiredAnnotationBeanPostProcessor。

protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable BeanWrapper bw) {
		/***
                 * 代码省略...
                 */ 
		//在填充属性之前，给 InstantiationAwareBeanPostProcessor最后一个机会 修改bean状态的机会。
		if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
			for (BeanPostProcessor bp : getBeanPostProcessors()) {
				if (bp instanceof InstantiationAwareBeanPostProcessor) {
					InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
					//执行postProcessAfterInstantiation 在实例话后 填充属性前
					if (!ibp.postProcessAfterInstantiation(bw.getWrappedInstance(), beanName)) {
						continueWithPropertyPopulation = false;
						break;
					}
				}
			}
		}
                /***
                 * 代码省略...
                 */     
		//初始化后处理器
		boolean hasInstAwareBpps = hasInstantiationAwareBeanPostProcessors();
		boolean needsDepCheck = (mbd.getDependencyCheck() != RootBeanDefinition.DEPENDENCY_CHECK_NONE);

		if (hasInstAwareBpps || needsDepCheck) {
			if (pvs == null) {
				pvs = mbd.getPropertyValues();
			}
			PropertyDescriptor[] filteredPds = filterPropertyDescriptorsForDependencyCheck(bw, mbd.allowCaching);
			if (hasInstAwareBpps) {
				for (BeanPostProcessor bp : getBeanPostProcessors()) {
					if (bp instanceof InstantiationAwareBeanPostProcessor) {
						InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
						pvs = ibp.postProcessPropertyValues(pvs, filteredPds, bw.getWrappedInstance(), beanName);
						if (pvs == null) {
							return;
						}
					}
				}
			}
			if (needsDepCheck) {
				checkDependencies(beanName, mbd, filteredPds, pvs);
			}
		}
	 
		if (pvs != null) {
			applyPropertyValues(beanName, mbd, bw, pvs);
		}
	}


初始化方法执行前后：这里的初始化方法 如init-method、实现InitializingBean的afterPropertiesSet方法。分别在这前后回调了BeanPostProcessor的2个方法，如下：

protected Object initializeBean(final String beanName, final Object bean, @Nullable RootBeanDefinition mbd) {
		/***
                 * 代码省略。。。
                 */     
                //前置执行
		Object wrappedBean = bean;
		if (mbd == null || !mbd.isSynthetic()) {
			wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
		}

		try {
			invokeInitMethods(beanName, wrappedBean, mbd);
		}
	 
		/***
	             * 代码省略。。。
	             */
	            //后置回调
		if (mbd == null || !mbd.isSynthetic()) {
			wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		}
	 
		return wrappedBean;
	}
至此，bean实例化、初始化已经完成，各个processors也在相应的地方进行了回调。

