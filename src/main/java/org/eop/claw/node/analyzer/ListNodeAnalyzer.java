package org.eop.claw.node.analyzer;

import org.eop.claw.node.WNode;
import org.eop.claw.node.WNodeAnalyzer;
import org.eop.claw.node.navi.ListNode;
/**
 * lixinjie 2016-12-26
 */
public class ListNodeAnalyzer extends WNodeAnalyzer {

	public ListNodeAnalyzer() {
		super("[", "]");
	}
	
	@Override
	protected WNode buildWnode(String segment) {
		return new ListNode(wnodeName, wnodeType, wnodeSetting);
	}

}
