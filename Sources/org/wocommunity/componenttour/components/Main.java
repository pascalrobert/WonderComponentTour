package org.wocommunity.componenttour.components;

import java.util.TimeZone;

import org.wocommunity.componenttour.model.BasicEntity;
import org.wocommunity.componenttour.model.RelatedEntity;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

public class Main extends ERXComponent {
	private ERXDisplayGroup<BasicEntity> _dg;
	private EOEditingContext _ec;
	public String booleanSelection;
	private BasicEntity _entityItem;
  
  public Main(WOContext context) {
		super(context);
	}
	
  private EOEditingContext editingContext() {
    if (_ec == null) {
      _ec = ERXEC.newEditingContext();
    }
    return _ec;
  }
  
	public ERXDisplayGroup<BasicEntity> dg() {
	  if (_dg == null) {
	    _dg = new ERXDisplayGroup<BasicEntity>();
	    _dg.setObjectArray(BasicEntity.fetchAllBasicEntities(editingContext()));
	  }
	  return _dg;
	}
	
	public boolean itsTrue() {
	  return true;
	}
	
	public void setEntityItem(BasicEntity entityItem) {
	  _entityItem = entityItem;
	}
	
	public BasicEntity entityItem() {
	  return _entityItem;
	}
	
	public BasicEntity singleEntity() {
	  return dg().allObjects().objectAtIndex(0);
	}
	
	public NSArray<RelatedEntity> relatedObjects() {
	  return RelatedEntity.fetchAllRelatedEntities(editingContext());
	}
	
	public NSArray<TimeZone> preferredTimeZones() {
	  return new NSArray<TimeZone>(new TimeZone[] { TimeZone.getTimeZone("America/Montrea") } );
	}
	
	public String stringWithLineBreaks() {
	  return "Some string with a\ttab and a \nline break";
	}
	
	public NSDictionary<String, String> bunchOfStrings() {
	  NSMutableDictionary<String, String> dict = new NSMutableDictionary<String, String>();
	  for (int i = 1; i < 10; i++) {
	    dict.takeValueForKey("String " + i, new Integer(i).toString());	    
	  }
	  return dict.immutableClone();
	}
	
}
