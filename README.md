Автор: Барышев В.
Отчет “Реставрация мумий” 
=============
*	Выпилил весь ненужный код, оставил последнюю функциональность
*	Разделил все на модули, их получилось 4: `shell`, `commands`, `database-core`, `presentation`. `Shell` содержит интерфейсы команд и сам интерфейс `shell` и его реализацию, он ни от чего не зависит, только использует com.google.guava для работы со строками. Commands подключает к себе `Shell` и `Database-core`, реализует команды для работы с файлами и для работы с базой данных. `Database-core` – мумия, к которой я подключил `google.gson` и `junit` (тесты остались с прошлого года) Presentation слой понятен, там все собирается в одну кучу!
*	Библиотеки использованы с лихвой. Не пришлось самому писать разбиение строки по пробелу\точке с запятой. Очень понравилось, что так можно легко и просто подключать модули и использовать в своем проекте. Использовал `apache-commons-io`, для работы с именами файлов и их копирования! (вообще всю логику с файлами я переписал, получилось намного лучше, чем было раньше)
*	Логгинг внедрил, логирую работу некоторых команд: `ls` и `cd`.  Тут все просто.
*	Некоторые классы оформлены с помощью Spring-аннотаций, например реализация shella и все что нужно для его работы. Сделал бины к System out и in (которые впоследствии используются реализацией Shella), и все команды работы с базой данных объявил `@Component`, поставил `@Autowierd` где надо. Получилось очень удобно,  в Shell  автоматом добавляются нужные мне команды (прямо всем списком). Команды работы с файлами я не аннотировал, хотя можно, зато сейчас видна разница. Для базы данных путь до файловой системы пробрасывается через аннотацию `@Value(“${database.directory:\”D:\”}”)`  т.е он сконфигурирован в properties файле.
*	`Configuration class`, `component scan` есть! `Spring Boot Starter`’a нет, хочется поподробней, не понял как его реализовывать, чтоб все работало.
*	Отчет есть.
