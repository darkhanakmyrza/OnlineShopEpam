В проекте использовалось apache-tomcat 8.5, JDK 1.8, СУБД MySQL

1. клонируем проект по этой ссылке [https://github.com/darkhanakmyrza/OnlineShopEpam](https://github.com/darkhanakmyrza/OnlineShopEpam) .
2. Ссылка для скачивание Apache-tomcat 8.5 [https://tomcat.apache.org/download-80.cgi](https://tomcat.apache.org/download-80.cgi) 
3. Запустите все скрипты в [db.sql](db.sql)
4. Затем откройте проект на intellij idea. Необходимо подключить сервер Apache Tomcat для запуска проекта. Нажимаете в меню Run – Edit configuration. Затем в левом верхнем углу значок + и выбираете Tomcat Server – Local.
5. Появится окно - настройки сервера – выбираете заранее установленный Tomcat в качестве Application server, затем указываете JRE 1.8 . Затем нажимаете кнопку Fix (OnlineShopEam:war exploded). Во вкладке Deployment нужно удалить строку в поле Application context
6. Можно запускать проект.