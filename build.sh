#!/bin/bash
set -ev

if [ -n "$TRAVIS_TAG" ]; then
    echo "Tag build, result will be uploaded to bintray";
    ./gradlew clean -PreleaseVersion=$TRAVIS_TAG build install bintrayUpload;
else
    echo "Not a tag build";
    ./gradlew clean build;
fi