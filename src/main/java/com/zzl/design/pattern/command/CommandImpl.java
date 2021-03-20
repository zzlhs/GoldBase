package com.zzl.design.pattern.command;

public class CommandImpl implements Command{
	
	private Receiver re;
	
	public CommandImpl() {
		re = new Receiver();
	}
	
	@Override
	public void execute() {
		re.action();
	}
	

}
