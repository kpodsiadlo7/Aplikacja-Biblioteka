# APPLICATION INFORMATION
#### Jest to moja pierwsza samodzielna aplikacja, która symuluje obsługę biblioteki
Możemy tworzyć czytelników oraz książki i później je wypożyczać. Każda następna identyczna 
książka dodana do systemu nie jest powielana w bazie danych tylko jest tworzony jej osobny egemplarz, których może być wiele.
Przy wypożyczeniu książki, następuje automatycznie zmiana statusu przy egzemplarzu, a jeżeli nie ma 
wolnych egzemplarzy danej książki to nie będziemy mogli jej wypożyczyć. Możemy
też książke zwrócić, co skutkuje automatyczną zmianą statusu i jej gotowością do wypożyczenia
przez kogoś innego. Jeżeli książka ma status zniszczona lub zagubiona, również nie będzie
można ich wypożyczyć.

#### Aplikacja udostępnia 6 endpointów:
1. Książka
* Utworzenie nowej książki
2. Egzemplarze książek
* Zmiana statusu dla książki enum (wypożyczona, uszkodzona itp.)
3. Czytelnicy
* Utworzenie nowego użytkownika / czytelnika
4. Wypożyczenie
* Wypożyczenie książki
* Zwrócenie książki
* Sprawdzenie ile książek danego tytułu jest możliwych do wypożyczenia
###
#### Zapraszam do zapoznania się z moim najnowszym projektem
#### https://github.com/kpodsiadlo7/Finalna-Aplikacja-Backend