package org.eop.claw.node.result.json.netsfjson;

import java.util.List;

import org.eop.chassis.util.ListUtil;
import org.eop.claw.node.RNode;
import org.eop.claw.node.WNode;
import org.eop.claw.node.index.DisperIndex;
import org.eop.claw.node.index.RangeIndex;
import org.eop.claw.node.index.SingleIndex;

import net.sf.json.JSONObject;
/**
 * lixinjie 2016-12-26
 */
public class JsonObjectListListResult extends RNode {

	protected List<List<JSONObject>> jsonObjectListList;
	
	public JsonObjectListListResult(List<List<JSONObject>> jsonObjectListList) {
		super("[[{}]]");
		this.jsonObjectListList = jsonObjectListList;
	}

	@Override
	public RNode getResult(WNode wnode) {
		if (wnode instanceof SingleIndex) {
			return new JsonObjectListResult(ListUtil.getList(jsonObjectListList, ((SingleIndex)wnode).getIndex()));
		} else if (wnode instanceof RangeIndex) {
			return new JsonObjectListListResult(ListUtil.getListList(jsonObjectListList, ((RangeIndex)wnode).getBeginIndex(), ((RangeIndex)wnode).getEndIndex()));
		} else if (wnode instanceof DisperIndex) {
			return new JsonObjectListListResult(ListUtil.getListList(jsonObjectListList, ((DisperIndex)wnode).getIndexes()));
		}
		return null;
	}

	@Override
	public List<List<JSONObject>> getValue() {
		return jsonObjectListList;
	}
}