FROM openjdk:8

WORKDIR /usrapp/balancer/bin

ENV PORT 6000

COPY /target/classes /usrapp/balancer/bin/classes
COPY /target/dependency /usrapp/balancer/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.App"]