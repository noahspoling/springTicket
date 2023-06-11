# springTicket

A project repository for the Spring Framework to showcase a Buisness Layer that provides a Presentation layer with data from a persistance (or data) layer server.

This project uses a role based access system to view, add, and resolve service tickets from a RMDB server. Spring security not implemented yet to provide tokens.

The resource folder will need the following application.properties file:
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop -- (DON"T USE THIS IN PRODUCTION) creates new tables if they exist based on the entities --
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect  -- Uses a postgress server. Change if using something else --
spring.jpa.properties.hibernate.format_sql=true
