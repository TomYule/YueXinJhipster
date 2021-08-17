```
wander@KcrissdeMacBook-Pro YueXinJhipster % npm link generator-jhipster-vuejs
jhipster -d --blueprints vuejs

added 1 package, and audited 3 packages in 2s

found 0 vulnerabilities
INFO! Using JHipster version installed globally
INFO! No custom sharedOptions found within blueprint: generator-jhipster-vuejs at /usr/local/lib/node_modules/generator-jhipster-vuejs
INFO! No custom commands found within blueprint: generator-jhipster-vuejs at /usr/local/lib/node_modules/generator-jhipster-vuejs
DEBUG!  cmd: jhipster:app
DEBUG!  args:
DEBUG!  opts: desc: [Default] Create a new JHipster application based on the selected options, help:
Example:
    jhipster

This will compose jhipster:client, jhipster:server and jhipster:languages to scaffold a full application

DEBUG!  cmdArgs:
INFO! Executing jhipster:app
DEBUG!  Options: debug: true, skip-cache: false, skip-install: false, force-install: false, ask-answered: false, skip-client: false, skip-server: false, skip-git: false, skip-commit-hook: false, skip-user-management: false, skip-check-length-of-identifier: false, skip-fake-data: false, with-entities: false, skip-checks: false, jhi-prefix: jhi, entity-suffix: , dto-suffix: DTO, yarn: false, experimental: false, prettier-java: false, blueprints: vuejs, skipCache: false, skipInstall: false, forceInstall: false, askAnswered: false, skipClient: false, skipServer: false, skipGit: false, skipCommitHook: false, skipUserManagement: false, skipCheckLengthOfIdentifier: false, skipFakeData: false, withEntities: false, skipChecks: false, jhiPrefix: jhi, entitySuffix: , dtoSuffix: DTO, prettierJava: false, from-cli: true, fromCli: true
DEBUG! No blueprint found for blueprint generator-jhipster-vuejs and app subgenerator: falling back to default generator
DEBUG! Error
Error: Generator jhipster-vuejs:app isn't registered.
    at module.exports.composeExternalModule (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base.js:1242:19)
    at module.exports.composeBlueprint (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-private.js:842:49)
    at /Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-blueprint.js:126:49
    at Array.forEach (<anonymous>)
    at module.exports.instantiateBlueprints (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-blueprint.js:118:24)
    at new module.exports (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/app/index.js:245:53)
    at Environment.instantiate (/Users/wander/.config/yarn/global/node_modules/yeoman-environment/lib/environment.js:673:23)
    at Environment.create (/Users/wander/.config/yarn/global/node_modules/yeoman-environment/lib/environment.js:645:19)
    at instantiateAndRun (/Users/wander/.config/yarn/global/node_modules/yeoman-environment/lib/environment.js:729:30)
    at Environment.run (/Users/wander/.config/yarn/global/node_modules/yeoman-environment/lib/environment.js:758:12)
DEBUG! Generator is starting


        ██╗ ██╗   ██╗ ████████╗ ███████╗   ██████╗ ████████╗ ████████╗ ███████╗
        ██║ ██║   ██║ ╚══██╔══╝ ██╔═══██╗ ██╔════╝ ╚══██╔══╝ ██╔═════╝ ██╔═══██╗
        ██║ ████████║    ██║    ███████╔╝ ╚█████╗     ██║    ██████╗   ███████╔╝
  ██╗   ██║ ██╔═══██║    ██║    ██╔════╝   ╚═══██╗    ██║    ██╔═══╝   ██╔══██║
  ╚██████╔╝ ██║   ██║ ████████╗ ██║       ██████╔╝    ██║    ████████╗ ██║  ╚██╗
   ╚═════╝  ╚═╝   ╚═╝ ╚═══════╝ ╚═╝       ╚═════╝     ╚═╝    ╚═══════╝ ╚═╝   ╚═╝

                            https://www.jhipster.tech

Welcome to JHipster v6.10.3
Application files will be generated in folder: /Users/wander/eclipse-workspace/YueXinJhipster
 _______________________________________________________________________________________________________________

  Documentation for creating an application is at https://www.jhipster.tech/creating-an-app/
  If you find JHipster useful, consider sponsoring the project at https://opencollective.com/generator-jhipster
 _______________________________________________________________________________________________________________

 ______________________________________________________________________________

  JHipster update available: 7.1.0 (current: 6.10.3)

  Run npm install -g generator-jhipster to update.

 ______________________________________________________________________________

? Which *type* of application would you like to create? Monolithic application (recommended for simple projects)
? [Beta] Do you want to make it reactive with Spring WebFlux? No
? What is the base name of your application? YueXinJhipster
DEBUG! No blueprint found for blueprint generator-jhipster-vuejs and server subgenerator: falling back to default generator
DEBUG! Error
Error: Generator jhipster-vuejs:server isn't registered.
    at module.exports.composeExternalModule (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base.js:1242:19)
    at module.exports.composeBlueprint (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-private.js:842:49)
    at /Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-blueprint.js:126:49
    at Array.forEach (<anonymous>)
    at module.exports.instantiateBlueprints (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/generator-base-blueprint.js:118:24)
    at new module.exports (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/server/index.js:63:53)
    at Environment.instantiate (/Users/wander/.config/yarn/global/node_modules/yeoman-environment/lib/environment.js:673:23)
    at instantiate (/Users/wander/.config/yarn/global/node_modules/yeoman-generator/lib/index.js:1196:23)
    at module.exports.composeWith (/Users/wander/.config/yarn/global/node_modules/yeoman-generator/lib/index.js:1227:33)
    at module.exports.composeServer (/Users/wander/.config/yarn/global/node_modules/generator-jhipster/generators/app/index.js:417:22)
DEBUG! Generator is starting
? What is your default Java package name? com.yuexin
? Do you want to use the JHipster Registry to configure, monitor and scale your application? No
? Which *type* of authentication would you like to use? HTTP Session Authentication (stateful, default Spring Security mechanism)
? Which *type* of database would you like to use? SQL (H2, MySQL, MariaDB, PostgreSQL, Oracle, MSSQL)
? Which *production* database would you like to use? MySQL
? Which *development* database would you like to use? MySQL
? Do you want to use the Spring cache abstraction? Yes, with the Caffeine implementation (local cache, for a single node)
? Do you want to use Hibernate 2nd level cache? No
? Would you like to use Maven or Gradle for building the backend? Maven
? Which other technologies would you like to use?
     info Using blueprint generator-jhipster-vuejs for client subgenerator
DEBUG! Generator is starting
DEBUG! Generator is starting
? Which *Framework* would you like to use for the client? Vue.js
? Would you like to use a Bootswatch theme (https://bootswatch.com/)? Default JHipster
     info Using blueprint generator-jhipster-vuejs for common subgenerator
DEBUG! Generator is starting
DEBUG! Generator is starting
? Would you like to enable internationalization support? Yes
? Please choose the native language of the application Chinese (Simplified)
? Please choose additional languages to install English
? Besides JUnit and Jest, which testing frameworks would you like to use? Gatling
? Would you like to install other generators from the JHipster Marketplace? No
     info Using blueprint generator-jhipster-vuejs for languages subgenerator
DEBUG! Generator is starting
DEBUG! Generator is starting

Installing languages: zh-cn, en
DEBUG! Time taken to write files: 3ms
Git repository initialized.

KeyStore 'src/main/resources/config/tls/keystore.p12' generated successfully.

DEBUG! Time taken to write files: 243ms
DEBUG! Time taken to write files: 379ms
DEBUG! Time taken to write files: 31ms
DEBUG! Time taken to write files: 15ms
    force ../../.yo-rc-global.json
   create .prettierrc
   create .prettierignore
   create src/main/jib/entrypoint.sh
   create checkstyle.xml
   create mvnw
   create mvnw.cmd
   create .mvn/wrapper/maven-wrapper.jar
   create .mvn/wrapper/maven-wrapper.properties
   create .mvn/wrapper/MavenWrapperDownloader.java
   create pom.xml
   create src/main/resources/banner.txt
   create src/main/resources/templates/error.html
   create src/main/resources/logback-spring.xml
   create src/main/resources/i18n/messages.properties
   create src/main/resources/config/liquibase/changelog/00000000000000_initial_schema.xml
   create src/main/resources/config/liquibase/master.xml
   create src/main/java/com/yuexin/security/SpringSecurityAuditorAware.java
   create src/main/java/com/yuexin/security/SecurityUtils.java
   create src/main/java/com/yuexin/security/AuthoritiesConstants.java
   create src/main/java/com/yuexin/security/package-info.java
   create src/test/java/com/yuexin/security/SecurityUtilsUnitTest.java
   create src/main/java/com/yuexin/config/SecurityConfiguration.java
   create src/main/java/com/yuexin/security/PersistentTokenRememberMeServices.java
   create src/main/java/com/yuexin/domain/PersistentToken.java
   create src/main/java/com/yuexin/repository/PersistentTokenRepository.java
   create src/main/java/com/yuexin/security/DomainUserDetailsService.java
   create src/main/java/com/yuexin/security/UserNotActivatedException.java
   create src/main/java/com/yuexin/YueXinJhipsterApp.java
   create src/main/java/com/yuexin/ApplicationWebXml.java
   create src/test/java/com/yuexin/ArchTest.java
   create src/main/java/com/yuexin/aop/logging/LoggingAspect.java
   create src/main/java/com/yuexin/config/package-info.java
   create src/main/java/com/yuexin/config/AsyncConfiguration.java
   create src/main/java/com/yuexin/config/DateTimeFormatConfiguration.java
   create src/main/java/com/yuexin/config/LoggingConfiguration.java
   create src/main/java/com/yuexin/config/ApplicationProperties.java
   create src/main/java/com/yuexin/config/JacksonConfiguration.java
   create src/main/java/com/yuexin/config/LocaleConfiguration.java
   create src/main/java/com/yuexin/config/LoggingAspectConfiguration.java
   create src/main/java/com/yuexin/config/WebConfigurer.java
   create src/main/java/com/yuexin/config/StaticResourcesWebConfiguration.java
   create src/main/java/com/yuexin/config/Constants.java
   create src/main/java/com/yuexin/config/CacheConfiguration.java
   create src/main/java/com/yuexin/config/CloudDatabaseConfiguration.java
   create src/main/java/com/yuexin/config/DatabaseConfiguration.java
   create src/main/java/com/yuexin/config/audit/package-info.java
   create src/main/java/com/yuexin/config/audit/AuditEventConverter.java
   create src/main/java/com/yuexin/config/LiquibaseConfiguration.java
   create src/main/java/com/yuexin/domain/package-info.java
   create src/main/java/com/yuexin/domain/AbstractAuditingEntity.java
   create src/main/java/com/yuexin/domain/PersistentAuditEvent.java
   create src/main/java/com/yuexin/repository/package-info.java
   create src/main/java/com/yuexin/service/EmailAlreadyUsedException.java
   create src/main/java/com/yuexin/service/InvalidPasswordException.java
   create src/main/java/com/yuexin/service/UsernameAlreadyUsedException.java
   create src/main/java/com/yuexin/service/package-info.java
   create src/main/java/com/yuexin/web/rest/errors/package-info.java
   create src/main/java/com/yuexin/web/rest/errors/BadRequestAlertException.java
   create src/main/java/com/yuexin/web/rest/errors/ErrorConstants.java
   create src/main/java/com/yuexin/web/rest/errors/ExceptionTranslator.java
   create src/main/java/com/yuexin/web/rest/errors/FieldErrorVM.java
   create src/main/java/com/yuexin/web/rest/errors/EmailAlreadyUsedException.java
   create src/main/java/com/yuexin/web/rest/errors/InvalidPasswordException.java
   create src/main/java/com/yuexin/web/rest/errors/LoginAlreadyUsedException.java
   create src/main/java/com/yuexin/web/rest/vm/package-info.java
   create src/main/java/com/yuexin/web/rest/package-info.java
   create src/main/java/com/yuexin/web/rest/ClientForwardController.java
   create src/test/java/com/yuexin/web/rest/TestUtil.java
   create src/test/java/com/yuexin/web/rest/errors/ExceptionTranslatorIT.java
   create src/test/java/com/yuexin/web/rest/errors/ExceptionTranslatorTestController.java
   create src/test/java/com/yuexin/web/rest/ClientForwardControllerTest.java
   create src/test/java/com/yuexin/config/timezone/HibernateTimeZoneIT.java
   create src/test/java/com/yuexin/repository/timezone/DateTimeWrapper.java
   create src/test/java/com/yuexin/repository/timezone/DateTimeWrapperRepository.java
   create src/test/resources/logback.xml
   create src/test/java/com/yuexin/config/WebConfigurerTest.java
   create src/test/java/com/yuexin/config/WebConfigurerTestController.java
   create src/test/java/com/yuexin/config/StaticResourcesWebConfigurerTest.java
   create src/test/gatling/conf/gatling.conf
   create src/test/gatling/conf/logback.xml
   create src/test/java/com/yuexin/security/DomainUserDetailsServiceIT.java
   create src/main/resources/config/liquibase/data/user.csv
   create src/main/resources/config/liquibase/data/authority.csv
   create src/main/resources/config/liquibase/data/user_authority.csv
   create src/main/resources/templates/mail/activationEmail.html
   create src/main/resources/templates/mail/creationEmail.html
   create src/main/resources/templates/mail/passwordResetEmail.html
   create src/main/java/com/yuexin/domain/Authority.java
   create src/main/java/com/yuexin/repository/AuthorityRepository.java
   create src/main/java/com/yuexin/repository/PersistenceAuditEventRepository.java
   create src/main/java/com/yuexin/service/AuditEventService.java
   create src/main/java/com/yuexin/web/rest/AuditResource.java
   create src/main/java/com/yuexin/repository/CustomAuditEventRepository.java
   create src/main/java/com/yuexin/domain/User.java
   create package.json
   create src/main/java/com/yuexin/repository/UserRepository.java
   create src/main/java/com/yuexin/service/UserService.java
   create src/main/java/com/yuexin/service/MailService.java
   create src/main/java/com/yuexin/service/dto/package-info.java
   create src/main/java/com/yuexin/service/dto/UserDTO.java
   create src/main/java/com/yuexin/service/dto/PasswordChangeDTO.java
   create src/main/java/com/yuexin/web/rest/vm/ManagedUserVM.java
   create src/main/java/com/yuexin/web/rest/AccountResource.java
   create src/main/java/com/yuexin/web/rest/UserResource.java
   create src/main/java/com/yuexin/web/rest/vm/KeyAndPasswordVM.java
   create src/main/java/com/yuexin/service/mapper/package-info.java
   create src/main/java/com/yuexin/service/mapper/UserMapper.java
   create src/test/java/com/yuexin/web/rest/AuditResourceIT.java
   create src/test/java/com/yuexin/service/AuditEventServiceIT.java
   create src/test/java/com/yuexin/repository/CustomAuditEventRepositoryIT.java
   create src/test/resources/templates/mail/testEmail.html
   create src/test/resources/i18n/messages_en.properties
   create src/test/java/com/yuexin/service/MailServiceIT.java
   create src/test/java/com/yuexin/service/UserServiceIT.java
   create src/test/java/com/yuexin/service/mapper/UserMapperTest.java
   create src/test/java/com/yuexin/web/rest/AccountResourceIT.java
   create src/test/java/com/yuexin/config/NoOpMailConfiguration.java
   create src/test/java/com/yuexin/web/rest/UserResourceIT.java
   create src/test/java/com/yuexin/web/rest/WithUnauthenticatedMockUser.java
   create .huskyrc
   create .postcssrc.js
   create config/index.js
   create config/dev.env.js
   create config/prod.env.js
   create webpack/webpack.common.js
   create webpack/webpack.dev.js
   create webpack/webpack.prod.js
   create webpack/vue.utils.js
   create webpack/loader.conf.js
   create webpack/utils.js
   create src/main/webapp/content/images/jhipster_family_member_0.svg
   create src/main/webapp/content/images/jhipster_family_member_1.svg
   create src/main/webapp/content/images/jhipster_family_member_2.svg
   create src/main/webapp/content/images/jhipster_family_member_3.svg
   create src/main/webapp/content/images/jhipster_family_member_0_head-192.png
   create src/main/webapp/content/images/jhipster_family_member_1_head-192.png
   create src/main/webapp/content/images/jhipster_family_member_2_head-192.png
   create src/main/webapp/content/images/jhipster_family_member_3_head-192.png
   create src/main/webapp/content/images/jhipster_family_member_0_head-256.png
   create src/main/webapp/content/images/jhipster_family_member_1_head-256.png
   create src/main/webapp/content/images/jhipster_family_member_2_head-256.png
   create src/main/webapp/content/images/jhipster_family_member_3_head-256.png
   create src/main/webapp/content/images/jhipster_family_member_0_head-384.png
   create src/main/webapp/content/images/jhipster_family_member_1_head-384.png
   create src/main/webapp/content/images/jhipster_family_member_2_head-384.png
   create src/main/webapp/content/images/jhipster_family_member_3_head-384.png
   create src/main/webapp/content/images/jhipster_family_member_0_head-512.png
   create src/main/webapp/content/images/jhipster_family_member_1_head-512.png
   create src/main/webapp/content/images/jhipster_family_member_2_head-512.png
   create src/main/webapp/content/images/jhipster_family_member_3_head-512.png
   create src/main/webapp/content/images/logo-jhipster.png
   create src/main/webapp/swagger-ui/index.html
   create src/main/webapp/swagger-ui/dist/images/throbber.gif
   create src/main/webapp/WEB-INF/web.xml
   create src/main/webapp/favicon.ico
   create src/main/webapp/robots.txt
   create src/main/webapp/404.html
   create src/main/webapp/index.html
   create src/main/webapp/manifest.webapp
   create src/main/webapp/app/app.vue
    force .yo-rc.json
   create src/main/docker/app.yml
   create src/main/docker/sonar.yml
   create src/main/docker/monitoring.yml
   create src/main/docker/prometheus/prometheus.yml
   create src/main/docker/grafana/provisioning/dashboards/dashboard.yml
   create src/main/docker/grafana/provisioning/dashboards/JVM.json
   create src/main/docker/grafana/provisioning/datasources/datasource.yml
   create src/main/docker/mysql.yml
   create src/main/resources/config/application.yml
   create src/main/resources/config/application-dev.yml
   create src/main/resources/config/application-tls.yml
   create src/main/resources/config/application-prod.yml
   create src/test/resources/config/application.yml
   create src/test/resources/config/application-testcontainers.yml
   create src/main/webapp/app/core/home/home.vue
   create src/main/webapp/app/core/error/error.vue
   create src/main/webapp/app/core/jhi-footer/jhi-footer.vue
   create tsconfig.json
   create src/main/webapp/app/core/jhi-navbar/jhi-navbar.vue
   create src/main/webapp/app/core/ribbon/ribbon.vue
   create src/main/webapp/app/shared/sort/jhi-sort-indicator.vue
   create tslint.json
   create src/main/webapp/content/css/loading.css
   create src/main/webapp/content/scss/_bootstrap-variables.scss
   create src/main/webapp/content/scss/global.scss
   create src/main/webapp/content/scss/vendor.scss
   create src/main/webapp/app/app.component.ts
   create src/main/webapp/app/shims-vue.d.ts
   create src/main/webapp/app/constants.ts
   create src/main/webapp/app/main.ts
   create src/main/webapp/app/shared/config/axios-interceptor.ts
   create src/main/webapp/app/shared/config/config.ts
   create src/main/webapp/app/shared/config/config-bootstrap-vue.ts
   create src/main/webapp/app/shared/config/store/account-store.ts
   create src/main/webapp/app/shared/config/store/alert-store.ts
   create src/main/webapp/app/shared/security/authority.ts
   create src/main/webapp/app/shared/jhi-item-count.vue
   create src/main/webapp/app/account/login-form/login-form.vue
   create src/main/webapp/app/account/change-password/change-password.vue
   create src/main/webapp/app/account/register/register.vue
   create src/main/webapp/app/account/reset-password/init/reset-password-init.vue
   create src/main/webapp/app/account/reset-password/finish/reset-password-finish.vue
   create src/main/webapp/app/account/settings/settings.vue
   create src/main/webapp/app/router/index.ts
   create src/main/webapp/app/router/admin.ts
   create src/main/webapp/app/router/entities.ts
   create src/main/webapp/app/router/pages.ts
   create src/main/webapp/app/locale/translation.service.ts
   create src/main/webapp/app/shared/config/formatter.ts
   create src/main/webapp/app/shared/config/store/translation-store.ts
   create src/main/webapp/app/core/home/home.component.ts
   create src/main/webapp/app/core/error/error.component.ts
   create src/main/webapp/app/core/jhi-footer/jhi-footer.component.ts
   create src/main/webapp/app/core/jhi-navbar/jhi-navbar.component.ts
   create src/main/webapp/app/core/ribbon/ribbon.component.ts
   create src/main/webapp/app/shared/date/filters.ts
   create src/main/webapp/app/shared/sort/jhi-sort-indicator.component.ts
   create src/main/webapp/app/shared/sort/sorts.ts
   create src/main/webapp/app/shared/alert/alert.service.ts
   create src/main/webapp/app/account/activate/activate.vue
   create src/main/webapp/app/account/sessions/sessions.vue
   create src/main/webapp/app/shared/alert/alert.mixin.ts
   create src/main/webapp/app/admin/configuration/configuration.vue
   create src/main/webapp/app/admin/docs/docs.vue
   create src/main/webapp/app/admin/health/health.vue
   create src/main/webapp/app/admin/health/health-modal.vue
   create src/main/webapp/app/admin/logs/logs.vue
   create src/main/webapp/app/admin/metrics/metrics.vue
   create src/main/webapp/app/admin/metrics/metrics-modal.vue
   create src/main/webapp/app/admin/audits/audits.vue
   create src/main/webapp/app/admin/user-management/user-management.vue
   create src/main/webapp/app/admin/user-management/user-management-view.vue
   create src/main/webapp/app/shared/data/data-utils.service.ts
   create src/main/webapp/app/shared/jhi-item-count.component.ts
   create src/main/webapp/app/shared/model/user.model.ts
   create src/main/webapp/app/account/account.service.ts
   create src/main/webapp/app/account/login-form/login-form.component.ts
   create src/main/webapp/app/account/login.service.ts
   create src/main/webapp/app/router/account.ts
   create src/main/webapp/app/account/change-password/change-password.component.ts
   create src/main/webapp/app/account/register/register.component.ts
   create src/main/webapp/app/account/register/register.service.ts
   create src/main/webapp/app/account/reset-password/init/reset-password-init.component.ts
   create src/main/webapp/app/account/reset-password/finish/reset-password-finish.component.ts
   create src/main/webapp/app/account/settings/settings.component.ts
   create src/main/webapp/app/account/activate/activate.component.ts
   create src/main/webapp/app/account/activate/activate.service.ts
   create src/main/webapp/app/admin/user-management/user-management-edit.vue
   create src/test/javascript/jest.conf.js
   create src/main/webapp/app/account/sessions/sessions.component.ts
   create src/main/webapp/app/admin/configuration/configuration.component.ts
   create src/main/webapp/app/admin/configuration/configuration.service.ts
   create src/main/webapp/app/admin/docs/docs.component.ts
   create src/main/webapp/app/admin/health/health.component.ts
   create src/main/webapp/app/admin/health/health-modal.component.ts
   create src/main/webapp/app/admin/health/health.service.ts
   create src/main/webapp/app/admin/logs/logs.component.ts
   create src/main/webapp/app/admin/logs/logs.service.ts
   create src/main/webapp/app/admin/metrics/metrics.component.ts
   create src/main/webapp/app/admin/metrics/metrics.service.ts
   create src/main/webapp/app/admin/metrics/metrics-modal.component.ts
   create src/main/webapp/app/admin/audits/audits.component.ts
   create src/main/webapp/app/admin/audits/audits.service.ts
   create src/main/webapp/app/admin/user-management/user-management.component.ts
   create src/main/webapp/app/admin/user-management/user-management-view.component.ts
   create src/main/webapp/app/admin/user-management/user-management-edit.component.ts
   create src/main/webapp/app/admin/user-management/user-management.service.ts
   create src/test/javascript/spec/app/account/account.service.spec.ts
   create src/test/javascript/spec/app/core/home/home.component.spec.ts
   create src/test/javascript/spec/app/core/error/error.component.spec.ts
   create src/test/javascript/spec/app/core/jhi-navbar/jhi-navbar.component.spec.ts
   create src/test/javascript/spec/app/core/ribbon/ribbon.component.spec.ts
   create src/test/javascript/spec/app/shared/alert/alert.service.spec.ts
   create src/test/javascript/spec/app/shared/config/axios-interceptor.spec.ts
   create src/test/javascript/spec/app/shared/data/data-utils.service.spec.ts
   create src/test/javascript/spec/app/admin/configuration/configuration.component.spec.ts
   create src/test/javascript/spec/app/admin/health/health.component.spec.ts
   create src/test/javascript/spec/app/admin/health/health-modal.component.spec.ts
   create src/test/javascript/spec/app/admin/health/health.service.spec.ts
   create src/test/javascript/spec/app/admin/logs/logs.component.spec.ts
   create src/test/javascript/spec/app/admin/metrics/metrics.component.spec.ts
   create .gitignore
   create .gitattributes
   create src/test/javascript/spec/app/admin/metrics/metrics-modal.component.spec.ts
   create .editorconfig
   create sonar-project.properties
   create .lintstagedrc.js
   create src/test/javascript/spec/app/admin/audits/audits.component.spec.ts
   create src/test/javascript/spec/app/shared/config/formatter.spec.ts
   create src/test/javascript/spec/app/account/login-form/login-form.component.spec.ts
   create src/test/javascript/spec/app/account/sessions/sessions.component.spec.ts
   create src/test/javascript/spec/app/account/login.service.spec.ts
   create src/test/javascript/spec/app/account/change-password/change-password.component.spec.ts
   create src/test/javascript/spec/app/account/register/register.component.spec.ts
   create src/test/javascript/spec/app/account/reset-password/init/reset-password-init.component.spec.ts
   create src/test/javascript/spec/app/account/reset-password/finish/reset-password-finish.component.spec.ts
   create src/test/javascript/spec/app/account/settings/settings.component.spec.ts
   create src/test/javascript/spec/app/account/activate/activate.component.spec.ts
   create src/test/javascript/spec/app/admin/user-management/user-management.component.spec.ts
   create src/test/javascript/spec/app/admin/user-management/user-management-view.component.spec.ts
   create src/test/javascript/spec/app/admin/user-management/user-management-edit.component.spec.ts
   create README.md
   create src/main/resources/i18n/messages_zh_CN.properties
   create src/test/resources/i18n/messages_zh_CN.properties
   create src/main/webapp/i18n/zh-cn/audits.json
   create src/main/webapp/i18n/zh-cn/configuration.json
   create src/main/webapp/i18n/zh-cn/error.json
   create src/main/webapp/i18n/zh-cn/login.json
   create src/main/webapp/i18n/zh-cn/home.json
   create src/main/webapp/i18n/zh-cn/metrics.json
   create src/main/webapp/i18n/zh-cn/logs.json
   create src/main/webapp/i18n/zh-cn/password.json
   create src/main/webapp/i18n/zh-cn/register.json
   create src/main/webapp/i18n/zh-cn/sessions.json
   create src/main/webapp/i18n/zh-cn/settings.json
   create src/main/webapp/i18n/zh-cn/user-management.json
   create src/main/webapp/i18n/zh-cn/activate.json
   create src/main/webapp/i18n/zh-cn/global.json
   create src/main/webapp/i18n/zh-cn/health.json
   create src/main/webapp/i18n/zh-cn/reset.json
   create src/main/resources/i18n/messages_en.properties
   create src/main/webapp/i18n/en/audits.json
   create src/main/webapp/i18n/en/configuration.json
   create src/main/webapp/i18n/en/error.json
   create src/main/webapp/i18n/en/login.json
   create src/main/webapp/i18n/en/home.json
   create src/main/webapp/i18n/en/metrics.json
   create src/main/webapp/i18n/en/logs.json
   create src/main/webapp/i18n/en/password.json
   create src/main/webapp/i18n/en/register.json
   create src/main/webapp/i18n/en/sessions.json
   create src/main/webapp/i18n/en/settings.json
   create src/main/webapp/i18n/en/user-management.json
   create src/main/webapp/i18n/en/activate.json
   create src/main/webapp/i18n/en/global.json
   create src/main/webapp/i18n/en/health.json
   create src/main/webapp/i18n/en/reset.json


I'm all done. Running npm install for you to install the required dependencies. If this fails, try running the command yourself.


npm WARN old lockfile
npm WARN old lockfile The package-lock.json file was created with an old version of npm,
npm WARN old lockfile so supplemental metadata must be fetched from the registry.
npm WARN old lockfile
npm WARN old lockfile This is a one-time fix-up, please be patient...
npm WARN old lockfile
npm ERR! code ERESOLVE
npm ERR! ERESOLVE unable to resolve dependency tree
npm ERR!
npm ERR! While resolving: yue-xin-jhipster@0.0.0
npm ERR! Found: tslint@6.1.2
npm ERR! node_modules/tslint
npm ERR!   dev tslint@"6.1.2" from the root project
npm ERR!
npm ERR! Could not resolve dependency:
npm ERR! peer tslint@"^5.0.0" from tslint-eslint-rules@5.4.0
npm ERR! node_modules/tslint-eslint-rules
npm ERR!   dev tslint-eslint-rules@"5.4.0" from the root project
npm ERR!
npm ERR! Fix the upstream dependency conflict, or retry
npm ERR! this command with --force, or --legacy-peer-deps
npm ERR! to accept an incorrect (and potentially broken) dependency resolution.
npm ERR!
npm ERR! See /Users/wander/.npm/eresolve-report.txt for a full report.

npm ERR! A complete log of this run can be found in:
npm ERR!     /Users/wander/.npm/_logs/2021-08-17T03_04_20_329Z-debug.log
DEBUG! Committing files to git
Application successfully committed to Git from /Users/wander/eclipse-workspace/YueXinJhipster.

If you find JHipster useful consider sponsoring the project https://www.jhipster.tech/sponsors/

Server application generated successfully.

Run your Spring Boot application:
./mvnw

Client application generated successfully.

Start your Webpack development server with:
 npm start


> yue-xin-jhipster@0.0.0 cleanup
> rimraf target/classes/static/

DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
DEBUG! Generator has ended
INFO! Congratulations, JHipster execution is complete!
wander@KcrissdeMacBook-Pro YueXinJhipster %
```
