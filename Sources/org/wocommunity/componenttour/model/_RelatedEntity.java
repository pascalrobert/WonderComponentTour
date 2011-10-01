// DO NOT EDIT.  Make changes to RelatedEntity.java instead.
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
public abstract class _RelatedEntity extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "RelatedEntity";

  // Attribute Keys
  public static final ERXKey<Integer> NUMBER_ATTRIBUTE = new ERXKey<Integer>("numberAttribute");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.componenttour.model.BasicEntity> BASIC_ENTITIES = new ERXKey<org.wocommunity.componenttour.model.BasicEntity>("basicEntities");

  // Attributes
  public static final String NUMBER_ATTRIBUTE_KEY = NUMBER_ATTRIBUTE.key();
  // Relationships
  public static final String BASIC_ENTITIES_KEY = BASIC_ENTITIES.key();

  private static Logger LOG = Logger.getLogger(_RelatedEntity.class);

  public RelatedEntity localInstanceIn(EOEditingContext editingContext) {
    RelatedEntity localInstance = (RelatedEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer numberAttribute() {
    return (Integer) storedValueForKey(_RelatedEntity.NUMBER_ATTRIBUTE_KEY);
  }

  public void setNumberAttribute(Integer value) {
    if (_RelatedEntity.LOG.isDebugEnabled()) {
    	_RelatedEntity.LOG.debug( "updating numberAttribute from " + numberAttribute() + " to " + value);
    }
    takeStoredValueForKey(value, _RelatedEntity.NUMBER_ATTRIBUTE_KEY);
  }

  public NSArray<org.wocommunity.componenttour.model.BasicEntity> basicEntities() {
    return (NSArray<org.wocommunity.componenttour.model.BasicEntity>)storedValueForKey(_RelatedEntity.BASIC_ENTITIES_KEY);
  }

  public NSArray<org.wocommunity.componenttour.model.BasicEntity> basicEntities(EOQualifier qualifier) {
    return basicEntities(qualifier, null, false);
  }

  public NSArray<org.wocommunity.componenttour.model.BasicEntity> basicEntities(EOQualifier qualifier, boolean fetch) {
    return basicEntities(qualifier, null, fetch);
  }

  public NSArray<org.wocommunity.componenttour.model.BasicEntity> basicEntities(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.wocommunity.componenttour.model.BasicEntity> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.componenttour.model.BasicEntity.RELATED_ENTITY_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.wocommunity.componenttour.model.BasicEntity.fetchBasicEntities(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = basicEntities();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.componenttour.model.BasicEntity>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.componenttour.model.BasicEntity>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToBasicEntities(org.wocommunity.componenttour.model.BasicEntity object) {
    includeObjectIntoPropertyWithKey(object, _RelatedEntity.BASIC_ENTITIES_KEY);
  }

  public void removeFromBasicEntities(org.wocommunity.componenttour.model.BasicEntity object) {
    excludeObjectFromPropertyWithKey(object, _RelatedEntity.BASIC_ENTITIES_KEY);
  }

  public void addToBasicEntitiesRelationship(org.wocommunity.componenttour.model.BasicEntity object) {
    if (_RelatedEntity.LOG.isDebugEnabled()) {
      _RelatedEntity.LOG.debug("adding " + object + " to basicEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToBasicEntities(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _RelatedEntity.BASIC_ENTITIES_KEY);
    }
  }

  public void removeFromBasicEntitiesRelationship(org.wocommunity.componenttour.model.BasicEntity object) {
    if (_RelatedEntity.LOG.isDebugEnabled()) {
      _RelatedEntity.LOG.debug("removing " + object + " from basicEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromBasicEntities(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _RelatedEntity.BASIC_ENTITIES_KEY);
    }
  }

  public org.wocommunity.componenttour.model.BasicEntity createBasicEntitiesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.componenttour.model.BasicEntity.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _RelatedEntity.BASIC_ENTITIES_KEY);
    return (org.wocommunity.componenttour.model.BasicEntity) eo;
  }

  public void deleteBasicEntitiesRelationship(org.wocommunity.componenttour.model.BasicEntity object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _RelatedEntity.BASIC_ENTITIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBasicEntitiesRelationships() {
    Enumeration<org.wocommunity.componenttour.model.BasicEntity> objects = basicEntities().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBasicEntitiesRelationship(objects.nextElement());
    }
  }


  public static RelatedEntity createRelatedEntity(EOEditingContext editingContext, Integer numberAttribute
) {
    RelatedEntity eo = (RelatedEntity) EOUtilities.createAndInsertInstance(editingContext, _RelatedEntity.ENTITY_NAME);    
		eo.setNumberAttribute(numberAttribute);
    return eo;
  }

  public static ERXFetchSpecification<RelatedEntity> fetchSpec() {
    return new ERXFetchSpecification<RelatedEntity>(_RelatedEntity.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<RelatedEntity> fetchAllRelatedEntities(EOEditingContext editingContext) {
    return _RelatedEntity.fetchAllRelatedEntities(editingContext, null);
  }

  public static NSArray<RelatedEntity> fetchAllRelatedEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _RelatedEntity.fetchRelatedEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<RelatedEntity> fetchRelatedEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<RelatedEntity> fetchSpec = new ERXFetchSpecification<RelatedEntity>(_RelatedEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<RelatedEntity> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static RelatedEntity fetchRelatedEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _RelatedEntity.fetchRelatedEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RelatedEntity fetchRelatedEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<RelatedEntity> eoObjects = _RelatedEntity.fetchRelatedEntities(editingContext, qualifier, null);
    RelatedEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one RelatedEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RelatedEntity fetchRequiredRelatedEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _RelatedEntity.fetchRequiredRelatedEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RelatedEntity fetchRequiredRelatedEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    RelatedEntity eoObject = _RelatedEntity.fetchRelatedEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no RelatedEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RelatedEntity localInstanceIn(EOEditingContext editingContext, RelatedEntity eo) {
    RelatedEntity localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
