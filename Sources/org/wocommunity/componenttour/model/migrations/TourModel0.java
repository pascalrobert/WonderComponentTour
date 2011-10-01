package org.wocommunity.componenttour.model.migrations;

import org.wocommunity.componenttour.model.BasicEntity;
import org.wocommunity.componenttour.model.RelatedEntity;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class TourModel0 extends ERXMigrationDatabase.Migration implements IERXPostMigration {
  
  @Override
  public NSArray<ERXModelVersion> modelDependencies() {
    return null;
  }
  
  @Override
  public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    // DO NOTHING
  }

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable relatedEntityTable = database.newTableNamed("RelatedEntity");
    relatedEntityTable.newIntegerColumn("id", false);
    relatedEntityTable.newIntegerColumn("numberAttribute", false);
    relatedEntityTable.create();
    relatedEntityTable.setPrimaryKey("id");

    ERXMigrationTable basicEntityTable = database.newTableNamed("BasicEntity");
    basicEntityTable.newIntegerColumn("id", false);
    basicEntityTable.newIntegerColumn("relatedEntityID", false);
    basicEntityTable.newStringColumn("textAttribute", 255, false);
    basicEntityTable.create();
    basicEntityTable.setPrimaryKey("id");

    basicEntityTable.addForeignKey("relatedEntityID", "RelatedEntity", "id");
  }

  public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
    for (int i = 1; i < 10; i++) {
      RelatedEntity related = RelatedEntity.createRelatedEntity(editingContext, i);
      BasicEntity.createBasicEntity(editingContext, "Object " + i, related);
    }
    editingContext.saveChanges();
  }
}