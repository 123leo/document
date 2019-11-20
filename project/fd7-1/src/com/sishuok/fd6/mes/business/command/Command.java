package com.sishuok.fd6.mes.business.command;

import com.sishuok.fd6.mes.business.vo.MsgVO;

public interface Command {
	public String execute(MsgVO vo);
}
