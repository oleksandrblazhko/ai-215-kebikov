### Прототипи методів програмних класів
| FR   | Опис вимоги                                   | Назва класу                   | Назва методу класу        |
| ---- | -------------------------------------------- | ------------------------------ | -------------------------- |
| FR1.1 | Користувач може активувати функцію автоматичних налаштувань температури | UserInformation  | setProfilePhoto(photo: string)  |
|      |                                               |                   | setEmail(email: string)          |
|      |                                               |                   | setNickname(nickname: string)    |
| FR1.2 | Користувач може отримувати доступ до системи AirDance та керувати нею для зміни температури. | User  | login(username: string, password: string) |
|      |                                               |                   | createAccount(username: string, password: string) |
| FR1.3 | Користувач може активувати функцію для покращення якості повітря в приміщенні. | TemperatureControl | setAirPurifier(activate: boolean) |
|      |                                               |                      | setMode(mode: string)           |
|      |                                               |                      | setTemperature(temp: int)       |
|      |                                               |                      | enableAutomaticSetting(enable: boolean) |
| FR3.1 | Користувач може отримувати коментарі(відгуки) від хореографів. | Comment | writeComment(commentText: string) |
|      |                                               |           | getDate(): string               |
