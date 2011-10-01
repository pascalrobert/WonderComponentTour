// DO NOT EDIT.  Make changes to BasicEntity.java instead.
package org.wocommunity.componenttour.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _BasicEntity extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BasicEntity";

  // Attribute Keys
  public static final ERXKey<String> TEXT_ATTRIBUTE = new ERXKey<String>("textAttribute");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.componenttour.model.RelatedEntity> RELATED_ENTITY = new ERXKey<org.wocommunity.componenttour.model.RelatedEntity>("relatedEntity");

  // Attributes
  public static final String TEXT_ATTRIBUTE_KEY = TEXT_ATTRIBUTE.key();
  // Relationships
  public static final String RELATED_ENTITY_KEY = RELATED_ENTITY.key();

  private static Logger LOG = Logger.getLogger(_BasicEntity.class);

  public BasicEntity localInstanceIn(EOEditingContext editingContext) {
    BasicEntity localInstance = (BasicEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String textAttribute() {
    return (String) storedValueForKey(_BasicEntity.TEXT_ATTRIBUTE_KEY);
  }

  public void setTextAttribute(String value) {
    if (_BasicEntity.LOG.isDebugEnabled()) {
    	_BasicEntity.LOG.debug( "updating textAttribute from " + textAttribute() + " to " + value);
    }
    takeStoredValueForKey(value, _BasicEntity.TEXT_ATTRIBUTE_KEY);
  }

  public org.wocommunity.componenttour.model.RelatedEntity relatedEntity() {
    return (org.wocommunity.componenttour.model.RelatedEntity)storedValueForKey(_BasicEntity.RELATED_ENTITY_KEY);
  }
  
  public void setRelatedEntity(org.wocommunity.componenttour.model.RelatedEntity value) {
    takeStoredValueForKey(value, _BasicEntity.RELATED_ENTITY_KEY);
  }

  public void setRelatedEntityRelationship(org.wocommunity.componenttour.model.RelatedEntity value) {
    if (_BasicEntity.LOG.isDebugEnabled()) {
      _BasicEntity.LOG.debug("updating relatedEntity from " + relatedEntity() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setRelatedEntity(value);
    }
    else if (value == null) {
    	org.wocommunity.componenttour.model.RelatedEntity oldValue = relatedEntity();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BasicEntity.RELATED_ENTITY_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _BasicEntity.RELATED_ENTITY_KEY);
    }
  }
  

  public static BasicEntity createBasicEntity(EOEditingContext editingContext, String textAttribute
, org.wocommunity.componenttour.model.RelatedEntity relatedEntity) {
    BasicEntity eo = (BasicEntity) EOUtilities.createAndInsertInstance(editingContext, _BasicEntity.ENTITY_NAME);    
		eo.setTextAttribute(textAttribute);
    eo.setRelatedEntityRelationship(relatedEntity);
    return eo;
  }

  public static ERXFetchSpecification<BasicEntity> fetchSpec() {
    return new ERXFetchSpecification<BasicEntity>(_BasicEntity.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BasicEntity> fetchAllBasicEntities(EOEditingContext editingContext) {
    return _BasicEntity.fetchAllBasicEntities(editingContext, null);
  }

  public static NSArray<BasicEntity> fetchAllBasicEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BasicEntity.fetchBasicEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<BasicEntity> fetchBasicEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BasicEntity> fetchSpec = new ERXFetchSpecification<BasicEntity>(_BasicEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BasicEntity> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BasicEntity fetchBasicEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _BasicEntity.fetchBasicEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BasicEntity fetchBasicEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BasicEntity> eoObjects = _BasicEntity.fetchBasicEntities(editingContext, qualifier, null);
    BasicEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BasicEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BasicEntity fetchRequiredBasicEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _BasicEntity.fetchRequiredBasicEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BasicEntity fetchRequiredBasicEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    BasicEntity eoObject = _BasicEntity.fetchBasicEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BasicEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BasicEntity localInstanceIn(EOEditingContext editingContext, BasicEntity eo) {
    BasicEntity localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
