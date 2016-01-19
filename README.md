# spring-auto-config-lab
This repo consists of two maven projects.
- The two *starter* projects that share a common parent on the root.
- The *service* that's a *Spring boot* project, lives on it's own and has *spring-boot-starter-parent* as it's parent.

## The Starters
**Starter-a** and **starter-b** are almost the same, the only difference is in class names and package names. **Starter-a**'s classes reside in the package `starters.jebl01.alpha.autoconfigure` and **starter-b**'s classes are in a package called `jebl01.beta.autoconfigure`.

The intention of the two starter projects is that when added as dependencies to the **service**, Spring should pick up their auto configuration. Both configurations (in **starter-a** and **starter-b**) come with conditions. All properties needs to be configured, and there has to be a `MetricRegistry` bean present in Spring (validated using `ConditionalOnBean`).

## The Service
The service is a fairly basic Spring boot application where the application main class is in a package called `jebl01` (**note! this is the root package of starter-b**). The service has **starter-a** and **starter-b** as dependencies.

## Run!
- `mvn clean install` on the root to install the *starter* projects
- start the service: `cd service && mvn spring-boot:run`

### Expected result
The service should pick up the auto configuration from both **starter-a** and **starter-b**

### Actual result
Only the auto configuration from **starter-a** is picked up. For **starter-b** the `ConditionalOnBean` condition fails.

Debug output (abbrevated for readability):
```
=========================
AUTO-CONFIGURATION REPORT
=========================


Positive matches:
-----------------

   AlphaAutoConfiguration matched
      - matched (OnPropertyCondition)
      - @ConditionalOnBean (types: com.codahale.metrics.MetricRegistry; SearchStrategy: all) found the following [metricRegistry] (OnBeanCondition)



Negative matches:
-----------------

   BetaAutoConfiguration did not match
      - matched (OnPropertyCondition)
      - @ConditionalOnBean (types: com.codahale.metrics.MetricRegistry; SearchStrategy: all) found no beans (OnBeanCondition)
```

#WAT!!
So, an auto configure project can't use the same packages as the service using it?! Packet scanning gone wild?
