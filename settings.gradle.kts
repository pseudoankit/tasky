rootProject.name = "Tasky"
include(":app")

include(":core:core")
include(":core:core-ui")
include(":core:design-system")
include(":core:agenda-manger")
include(":core:database-manager")
include(":core:navigation")
include(":core:preferences-manager")
include(":core:alarm-manager")
include(":core:notification-manager")
include(":core:permission-manager")
include(":core:app-shortcuts-n-widgets")

include(":feature:authentication")
include(":feature:home")
include(":feature:agenda:event")
include(":feature:agenda:reminder")
include(":feature:agenda:task")
include(":feature:profile")
include(":feature:developer-tools")

include(":benchmark")
