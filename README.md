![logoTodo.png](src%2Fmain%2Fresources%2Fstatic%2Fimages%2FlogoTodo.png)

# Todo list

<h3>Описание проекта</h3>
<h6>Приложение представляет собой сайт со списком задач которые размещают пользователи. <br>
Задачи имеют категорию и приоритет. В приложении задачи разделены по статусу, завершённое и в работе. <br>
Реализована возможность просматривать список всех задач, только не завершённых задач и завершенных задач. <br>
Каждую задачу можно просмотреть детально. Каждую задачу возможно отредактировать завершить удалить. <br>
Так же реализована возможность добавления новой задачи. <br>
Пользоваться приложение может только зарегистрированный и авторизованный пользователь. <br>
При первичной регистрации пользователь указывает свой часовой пояс, <br>
и дата создания задачи отображается с учетом часового пояса. <br>
При добавлении новой задачи текущий пользователь привязывается к данной задачи как создатель. <br></h6>

<h3>Стек технологий</h3>
Java 17 <br>
PostgreSQL 14 <br>
Spring BOOT 2.7.4 <br>
Liqubase 4.15 <br>
Hibernate 5.6.11 <br>
h2database 2.14 <br>
Mockito <br>
Lombok 1.18 <br>
Bootstrap 5.3 <br>
Thymeleaf 3.1 <br>

<h3>Требование к окружению</h3>
JDK 17, Maven 3.8, PostgreSQL 14. <br>

<h3>Запуск приложения</h3>

1. Создайте базу данных my_todo при помощи консоли PostgreSQL или терминала pgAdmin:<br>
   """CREATE DATABASE my_todo"""
2. Скопировать проект из репозитория по ссылке:
   <a href=https://git@github.com:Dima-Stepanov/my_todo.git><b>Проект TODO List</b></a>
3. Перейдите в корень проекта и при помощи Maven соберите проект командой:<br>
   """mvn install -Pproduction -Dmaven.test.skip=true"""
4. После успешной сборки проекта перейдите в каталог собранного проекта <b>target</b> и запустите приложение
   командой:<br>
   """java -jar my_todo-1.0.jar"""
5. В браузере перейдите по ссылке http://localhost:8080/index

<h3>Взаимодействие с приложением</h3>







<h3>Контакты</h3>
email: <b>haoos@inbox.ru</b> <br>
tl: <a href=https://t.me/Dima202020><b>Dima202020<b></a> <br>
github.com: <a href=https://github.com/Dima-Stepanov><b>Dima-Stepanov<b></a>
