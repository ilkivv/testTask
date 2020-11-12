Тестовое задание
=====================
### 1. Установка jdk  
	a. устанавливаем Java SE 8 перейдя по ссылке https://www.oracle.com/java/technologies/javase-downloads.html  
	b. устанавливаем PATH переменные среды как показано здесь https://techarks.ru/general/kak-ustanovit-java_home-v-windows-10/  
### 2. Установка контейнера сервлетов
устанавливаем tomcat 9 перейдя по ссылке [тут](https://tomcat.apache.org/)  
проверить установку можно перейдя по адресу http://localhost:ваш_порт/  
### 3.Установка gradle  
Чтобы установить gradle, необходимо:  
	a. скачать версию 5.6 перейдя по ссылке [здесь](https://gradle.org/releases/)  
	b. создать новый каталог C:\Gradle  
	c. распаковать загруженный архив и перенести папку gradle-* в только что созданную папку  
	d. настроить PATH переменную среды, чтобы включить в нее bin каталог распакованного дистрибутива.  
проверить установку можно введя команду в терминале $ gradle -v  
### 4. Установка Mysql 
  a. перейти и скачать [установщик](https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.11.0.msi/)  
  b. выполнить установку  
  с. В mysql command line выполнить команду `CREATE DATABASE test_db CHARACTER SET utf8 COLLATE utf8_general_ci;`  
### 4. Клонировать проект  
  a. для развертывания проекта необходим Git  
  b. скачать его можно перейдя по ссылке [git](https://git-scm.com/download/win)  
  c. произвести установку  
  d. клонировать проект командой git clone https://github.com/ilkivv/testTask.git в нужную папку  
  e. настроить параметры поключения к бд в файле src/main/resources/application.properties
### 5. Сборка проекта  
  в терминале перейти в папку с проектом и выполнить команду `gradle clean build -x test`  
### 6. Развернуть приложение на сервере  
  a. перенести .war файл из каталога <app>/build/libs в <CATALINA_HOME>/webapps  
	b. Добавить виртуальный хост в файл <CATALINA_HOME>/conf/server.xml, например     
	`<Host name="test.com" appBase="webapps/test">  
		<Context path="" docBase="C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\test" debug="0" reloadable="true">  
		</Context>  
	</Host>`  
	b. перезапустить сервер
 ### 7. Готово
