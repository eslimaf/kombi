Kombi: A Lightweight Reusable Message Bus
======
[![Build Status](https://travis-ci.org/eslimaf/kombi.svg?branch=master)](https://travis-ci.org/eslimaf/kombi)
[ ![Download](https://api.bintray.com/packages/eslimaf/maven/kombi/images/download.svg) ](https://bintray.com/eslimaf/maven/kombi/_latestVersion)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d5992575918c4e38b6ea6d3d31592d02)](https://www.codacy.com/app/eslimaf/kombi?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=eslimaf/kombi&amp;utm_campaign=Badge_Grade)

## Install
### Maven
```xml
<dependency>
  <groupId>com.eslimaf</groupId>
  <artifactId>kombi</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
```
### Gradle
```gradle
compile 'com.eslimaf:kombi:<latest version>'
```

## Usage
The API is based on getting your [Kombi](https://en.wikipedia.org/wiki/Volkswagen_Type_2) out of the Garage.

*Garage will hold a unique <Object> instance*
```java
String licensePlate = "ObjectBus";
RxKombi<Object> objectKombi = Garage.getInstance().rideKombi(licensePlate);
```
Once you get a RxKombi object you will be able to send and subscribe
```java
objectKombi.send(new Object());
```

or

```java
objectKombi.toObservable().<RxJava Observable construction>
```