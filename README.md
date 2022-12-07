# Алгоритм LZW для стискання текстових даних

### 1. Формулювання завдання практики

Завданням практики є опис та реалізація алгоритму стискання текстових даних за допомогою алгоритму Лемпеля – Зіва – Велча. Необхідно реалізувати алгоритм на будь-якій сучасній мові програмування і провезти аналіз роботи реалізованого алгоритму. Аналіз відбувається за рахунок стискання файлу з будь-яким англомовним текстом та порівняння його розміру із вихідним файлом та файлом із розпакованим текстом.

### 2. Результати роботи

Упродовж практики було описано і розроблено алгоритм Лемпеля – Зіва – Велча для стискання текстових даних. Реалізація алгоритму була виконана мовою програмування Kotlin із застосуванням інтегрованого середовища програмування IntelliJ IDEA. Алгоритм правильно стискає та розпаковує текст без змін. Реалізований алгоритм наявний у поточному репозиторії.

Ідея алгоритму полягає у використанні спеціального словника, який має записи усіх повторюваних комбінацій символів з тексту. Зі збільшенням тексту збільшується ефективність стискання, адже кількість і довжина однакових підрядків збільшується.

Був протестований реалізований алгоритм за допомогою п’єси Шекспіра «Merchant of Venice», на коді стандартних бібліотек Kotlin, а також на випадковому наборі символів англійської абетки, цифр, крапки, коми та пробілу. Результат тестування наведений у таблиці нижче.

| Тип        | Вхідний   | Вихідний  | Ефективність |
|------------|-----------|-----------|--------------|
| Випадковий | 164.62 kB | 162.01 kB | 1.59%        |
| Шекспір    | 117.49 kB | 79.85 kB  | 32.04%       |
| Код Kotlin | 204.47 kB | 95.52 kB  | 53.29%       |

З таблиці видно, що природний текст стискається зі значно більшою ефективністю, ніж набір випадкових символів. Це може обумовлюватись особливістю роботи алгоритму, який шукає послідовності схожих символів і записує їх у словник. У природному тексті наявна велика кількість однакових слів та підрядків, у той час, коли у випадковому тексті кількість різних підрядків значно більша.

Код мовою програмування Kotlin стискається із найвищою ефективністю, адже будь-який код має величезну кількість однакових підрядків, до яких відносяться ключові слова, команди, назви змінних та методів, константи та інше. Таким чином алгоритм стискання тексту показує кращі результати на текстових файлах із високою кількістю однакових підрядків, до яких відноситься будь-який код будь-якою мовою програмування.

### 3. Висновки

У процесі роботи над практикою було розроблено та протестовано алгоритм стискання текстових даних. Алгоритм працює ефективніше природною мовою, ніж на наборі випадкових символів, але найбільш ефективно працює на текстових файлах із високою кількістю однакових підрядків, на кшталт програмного коду. Таким чином алгоритм можна використовувати для стискання великих текстових файлів, на кшталт п’єс, казок, інших літературних творів, а також файлів програмного коду.

### 4. Список використаних джерел

1. [Constructing Word-Based Text Compression Algorithms – R. Nigel Horspool, Gordon V. Cormack – 10 с.](https://webhome.cs.uvic.ca/~nigelh/Publications/wordCompression.pdf)
2. [Fast Text Compression Using Multiple Static Dictionaries – A. Carus, A. Mesut – 9 с.](https://d1wqtxts1xzle7.cloudfront.net/35437466/1013-1021-libre.pdf?1415242598=&response-content-disposition=inline%3B+filename%3DISSDC_Digram_Coding_Based_Lossless_Data.pdf&Expires=1670447553&Signature=PMkhTnuEULOV687Z8sUopgWx~Ul8~SQx2fsVyIqy5uwfJcwwfuEw3z9Cu0da2jE4i35AVoOkbO9VzaRZ72s9-WbnRsEbuhmHyWaof068loFCMVxkX-d8rER4VlGd3yR~qp~lS7QcYXqzLIUeNcop-P33BNjgfVv0j70LqbrbdC7tzMVY2Di5mQlJFkPRYpd3gJ6k9rVeq63O4ECthmWS~TNVIJdJMPt0kd9hGxqxWXNDVnz1lj7Ex28dKWoMc2byzwhwrmB3hKP~p3X0OIRVgwCzn9gFPj~cjiVsswAcne0ZyO2Qo5d2kph5ljWy72GRMdV1kjZLMv5KqpaeqTHdVg__&Key-Pair-Id=APKAJLOHF5GGSLRBV4ZA)
3. [Реалізація алгоритму LZW](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/kotlin/LZW.kt)
4. Випадковий текст: [вхідний](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/random.txt), [стиснутий](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/random_compressed.txt), [розпакований](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/random_decompressed.txt)
5. Текст п'єси-комедії "Венеційський купець" Шекспіра: [вхідний](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/merchant.txt), [стиснутий](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/merchant_compressed.txt), [розпакований](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/merchant_decompressed.txt)
6. Файл програмного коду стандартних бібліотек Kotlin: [вхідний](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/kotlin.txt), [стиснутий](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/kotlin_compressed.txt), [розпакований](https://github.com/knu-6-tochanenko/Practice/blob/master/src/main/resources/kotlin_decompressed.txt)
