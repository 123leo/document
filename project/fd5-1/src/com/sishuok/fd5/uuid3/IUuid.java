package com.sishuok.fd5.uuid3;

import com.sishuok.fd5.uuid3.arithmatic.IArithmatic;

public interface IUuid {
	public String genUuid(String businessType,
			boolean needFormat,String formatStr,String c,int len,
			boolean needArithmatic,IArithmatic ia,
			int cacheNum
			);
	
	//�ֵ�001 ��
	//20
}


//���磺1s  ϵͳ����һ����ˮ��������Ҫ10ms  ==100��
//������еĴ����ٶȺ�ʱ�䣬 �����߳���� Ч�ʣ� ����һ����ˮ��������Ҫ1ms�� ===1000��
//����===��ͬһʱ�������о���������===����һ����ǿ��ʱ��Խ�����������ʾ�Խ��

//�߲����������
//����������===������
//��߳������еĴ����ٶ�===�����桢��д���롢ҳ�澲̬�����첽����......


