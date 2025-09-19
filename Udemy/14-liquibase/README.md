# Liquibase Migration

**Liquibase**
- Open source
- Database independent library

**Advantages of Liquibase**
- Automatic updates
- Automatic creation and execution of rollback operations
- Support different formats

**Supported formats**
- XML
- JSON
- YAML
- SQL

**Changeset**
- A changeset describes a set of changes that liquibase executes within one transaction
- To enable successful rollbacks and keep track of the executed changesets, each changeset is identified by
  - Author name
  - Id
