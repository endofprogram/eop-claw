package org.eop.claw.internal.xml;

import org.eop.claw.AbstractClaw;
import org.eop.claw.ClawSetting;
import org.eop.claw.IClaw;
import org.eop.claw.node.ResultNode;
import org.eop.claw.node.result.xml.w3c.W3cElementResult;
import org.w3c.dom.Element;
/**
 * lixinjie 2016-12-26
 */
public class W3cXmlClaw extends AbstractClaw {

	public W3cXmlClaw(Element element) {
		this(new W3cElementResult(element));
	}
	
	public W3cXmlClaw(Element element, ClawSetting clawSetting) {
		this(new W3cElementResult(element), clawSetting);
	}
	
	protected W3cXmlClaw(ResultNode rootResultNode) {
		super(rootResultNode);
	}
	
	protected W3cXmlClaw(ResultNode rootResultNode, ClawSetting clawSetting) {
		super(rootResultNode, clawSetting);
	}
	
	@Override
	protected IClaw getClaw() {
		return new W3cXmlClaw(currentResultNode, clawSetting);
	}

}
