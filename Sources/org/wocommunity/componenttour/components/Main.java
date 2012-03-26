package org.wocommunity.componenttour.components;

import java.util.TimeZone;

import org.wocommunity.componenttour.model.BasicEntity;
import org.wocommunity.componenttour.model.RelatedEntity;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

public class Main extends ERXComponent {
  private ERXDisplayGroup<BasicEntity> _dg;
  private EOEditingContext _ec;
  public String booleanSelection;
  private BasicEntity _entityItem;
  private String key;
  private String selectedKey = BasicEntity.TEXT_ATTRIBUTE_KEY;
  private String value = "some value";

  public Main(WOContext context) {
    super(context);
  }

  public EOEditingContext editingContext() {
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

  public NSArray<String> keyList() {
    return new NSArray<String>(new String[] { BasicEntity.TEXT_ATTRIBUTE_KEY, BasicEntity.RELATED_ENTITY_KEY });
  }

  public String key() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String selectedKey() {
    return selectedKey;
  }

  public void setSelectedKey(String selectedKey) {
    this.selectedKey = selectedKey;
  }

  public String sourceEntityName() {
    return BasicEntity.ENTITY_NAME;
  }

  public String value() {
    return value;
  }
  
  public void setValue(String value) {
    this.value = value;
    NSLog.out.appendln("value " + value);
  }
  
  public NSMutableDictionary errors() {
    return new NSMutableDictionary(new String[] { "Error 1", "Error 2" }, new String[] { "error1", "error2" });
  }
  
}
