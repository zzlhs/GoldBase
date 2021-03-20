package com.zzl.design.pattern.strategy;

public class Test {
	public static void main(String[] args) {
		Strategy strategyA = new StrategyA();
		Context context = new Context(strategyA);
		context.contextInterface();
	}
}
