package com.sishuok.fd8.permitmgr.validate.expression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TerminalExpression extends AbstractExpression{

	public TerminalExpression(AbstractExpression ae) {
		super(ae);
	}
	public  boolean interpret(Context ctx){
		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
		try {
			Object obj = se.eval(ctx.getExpression());
			return Boolean.valueOf(obj.toString());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return false;
	}
}
