-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 30 Sty 2017, 17:02
-- Wersja serwera: 10.1.16-MariaDB
-- Wersja PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `magazyn`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria`
--

CREATE TABLE `kategoria` (
  `ID_Kat` int(11) NOT NULL,
  `Nazwa` varchar(24) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Zrzut danych tabeli `kategoria`
--

INSERT INTO `kategoria` (`ID_Kat`, `Nazwa`) VALUES
(1, 'Elektonika'),
(2, 'Owoce');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkt`
--

CREATE TABLE `produkt` (
  `ID_Prod` int(11) NOT NULL,
  `Nazwa` varchar(24) COLLATE utf8_bin DEFAULT NULL,
  `Cena` double DEFAULT NULL,
  `Ilosc` int(11) DEFAULT NULL,
  `ID_Kat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Zrzut danych tabeli `produkt`
--

INSERT INTO `produkt` (`ID_Prod`, `Nazwa`, `Cena`, `Ilosc`, `ID_Kat`) VALUES
(1, 'sdwe', 3, 2, 1),
(2, 'dwef', 123, 4, 1),
(3, 'dfe', 213, 23, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownik`
--

CREATE TABLE `uzytkownik` (
  `ID_Uzyt` int(11) NOT NULL,
  `Login` varchar(24) COLLATE utf8_bin NOT NULL,
  `Haslo` varchar(24) COLLATE utf8_bin NOT NULL,
  `Imie` varchar(24) COLLATE utf8_bin NOT NULL,
  `Nazwisko` varchar(24) COLLATE utf8_bin NOT NULL,
  `ID_Kat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Zrzut danych tabeli `uzytkownik`
--

INSERT INTO `uzytkownik` (`ID_Uzyt`, `Login`, `Haslo`, `Imie`, `Nazwisko`, `ID_Kat`) VALUES
(1, 'waldek', 'waldek', 'waldek', 'waldek', 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `kategoria`
--
ALTER TABLE `kategoria`
  ADD PRIMARY KEY (`ID_Kat`);

--
-- Indexes for table `produkt`
--
ALTER TABLE `produkt`
  ADD PRIMARY KEY (`ID_Prod`),
  ADD KEY `ID_Kat` (`ID_Kat`);

--
-- Indexes for table `uzytkownik`
--
ALTER TABLE `uzytkownik`
  ADD PRIMARY KEY (`ID_Uzyt`),
  ADD KEY `ID_Kat` (`ID_Kat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  MODIFY `ID_Kat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `produkt`
--
ALTER TABLE `produkt`
  MODIFY `ID_Prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
  MODIFY `ID_Uzyt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `produkt`
--
ALTER TABLE `produkt`
  ADD CONSTRAINT `produkt_ibfk_1` FOREIGN KEY (`ID_Kat`) REFERENCES `kategoria` (`ID_Kat`);

--
-- Ograniczenia dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
  ADD CONSTRAINT `uzytkownik_ibfk_1` FOREIGN KEY (`ID_Kat`) REFERENCES `kategoria` (`ID_Kat`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
