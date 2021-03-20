package com.zzl.design.pattern.command;

public class Invoker {
	private Command command;
	
	public Invoker(Command command) {
		command = command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void call() {
		System.out.println("Invoker...call()");
		command.execute();
	}
}
