package org.eop.claw.node.result.json.fastjson;

import java.util.List;

import org.eop.chassis.util.ListUtil;
import org.eop.chassis.util.TypeUtil;
import org.eop.claw.node.RNode;
import org.eop.claw.node.WNode;
import org.eop.claw.node.index.DisperIndex;
import org.eop.claw.node.index.RangeIndex;
import org.eop.claw.node.index.SingleIndex;
import org.eop.claw.node.result.ElementListListResult;

/**
 * @author lixinjie 201704-13
 */
public class ListListListResult extends RNode {

	protected List<List<List<Object>>> listListList;
	
	public ListListListResult(List<List<List<Object>>> listListList) {
		super("[[[]]]");
		this.listListList = listListList;
	}
	
	@Override
	public RNode getResult(WNode wnode) {
		if (wnode instanceof SingleIndex) {
			if (isJsonObjectListList()) {
				return new JsonObjectListListResult(ListUtil.getFastJsonObjectListList(listListList, ((SingleIndex)wnode).getIndex()));
			}
			if (isListListList()) {
				return new ListListListResult(ListUtil.getListListList(listListList, ((SingleIndex)wnode).getIndex()));
			}
			return new ElementListListResult(ListUtil.getElementListList(listListList, ((SingleIndex)wnode).getIndex()));
		} else if (wnode instanceof RangeIndex) {
			return new ListListListResult(ListUtil.getListListList(listListList, ((RangeIndex)wnode).getBeginIndex(), ((RangeIndex)wnode).getEndIndex()));
		} else if (wnode instanceof DisperIndex) {
			return new ListListListResult(ListUtil.getListListList(listListList, ((DisperIndex)wnode).getIndexes()));
		}
		return null;
	}

	@Override
	public List<List<List<Object>>> getValue() {
		return listListList;
	}

	protected boolean isJsonObjectListList() {
		return TypeUtil.isFastJsonObject(ListUtil.getFirst(ListUtil.getFirst(ListUtil.getFirst(listListList))));
	}
	
	protected boolean isListListList() {
		return TypeUtil.isFastJsonArray(ListUtil.getFirst(ListUtil.getFirst(ListUtil.getFirst(listListList))));
	}
}
