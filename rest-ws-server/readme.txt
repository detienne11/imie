Java Map en REST----------------
Url     : http://codes-sources.commentcamarche.net/source/101722-java-map-en-restAuteur  : KXDate    : 10/11/2016
Licence :
=========

Ce document intitulé « Java Map en REST » issu de CommentCaMarche
(codes-sources.commentcamarche.net) est mis à disposition sous les termes de
la licence Creative Commons. Vous pouvez copier, modifier des copies de cette
source, dans les conditions fixées par la licence, tant que cette note
apparaît clairement.

Description :
=============

Ceci est un petite application en Java pour introduire la technologie REST.
<br
 />
<br />Il s'agit juste d'exposer les diffÃ©rentes mÃ©thodes d'une Map&lt;Str
ing,String&gt;
<br />
<br />Les mÃ©thodes disponibles sont :
<br />
<br /><p
re class="code" data-mode="java">GET localhost:8080/map/size
GET localhost:8080/
map/isEmpty
GET localhost:8080/map/containsKey/{key}
GET localhost:8080/map/cont
ainsValue/{value}
GET localhost:8080/map/get/{key}
GET localhost:8080/map/keySet

GET localhost:8080/map/values
GET localhost:8080/map/entrySet

PUT localhost:80
80/map/put/{key}/{value}

DELETE localhost:8080/map/remove/{key}
DELETE localhos
t:8080/map/clear</pre>
<br />
<br />Compilation (avec <a href='http://www.comm
entcamarche.net/faq/maven-696'>Maven</a>) : <pre class="code inline inline-code"
 data-mode="java">mvn clean package</pre>
<br />
<br />ExÃ©cution : <pre class
="code inline inline-code" data-mode="java">java -jar target/map-service-1.0-jar
-with-dependencies.jar</pre>
<br />
<br />Exemple (en <a href='https://fr.wiki
pedia.org/wiki/CURL' rel='noopener noreferrer' target='_blank'>cURL</a>)
<br />

<br /><pre class="code" data-mode="java">$ curl -X GET http://localhost:8080/m
ap/isEmpty
true
$ curl -X PUT http://localhost:8080/map/put/toto/tata

$ curl -X
 GET http://localhost:8080/map/size
1
$ curl -X GET http://localhost:8080/map/ge
t/toto
tata
$ curl -X DELETE http://localhost:8080/map/remove/toto
</pre>
