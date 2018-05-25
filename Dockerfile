FROM niaquinto/gradle
MAINTAINER Priyank Shah (priyank.shah217@gmail.com)
COPY build.gradle .
RUN gradle resolveDependencies
COPY . .
ENTRYPOINT gradle e2e -DSeleniumHub=$SELENIUM_HUB -DBrowserType=$BROWSER