package org.eop.claw.node.element;

import java.util.Map;

import org.eop.claw.node.ElementNode;
/**
 * lixinjie 2016-12-26
 */
public class FloatElement extends ElementNode {

	public FloatElement(String name, String type, Map<String, String> setting) {
		super(name, type, setting, Float.class);
	}
}
