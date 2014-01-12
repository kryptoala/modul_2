package Lawyer;

import java.util.Vector;

/**
 * Klasa zawierajaca zmienne konieczne do prawidlowgo wyswietlenia graficznego interfejsu uzytkownika w module przeznaczonym
 * do dzielenia sekretu.
 *
 */
public class LawyerConfig {

	/**
	 * Tablica lancuchow znakowych zawierajacy nazwy plikow graficznych wyswietlanych w menu modulu dzielenia sekretu.
	 */
	public static String[] MenuButtons = { "podziel_sekret.png", "rozeslij_czesci_sekretu.png", "zamknij.png", "podzial_sekretu.png"};

	/**
	 * Lancuch znakowy stanowiacy tytul menu.
	 */
	public static String MenuTitle = "Menu";
	
	/**
	 * Tablica zmiennych typu int okreslajacych wymiary okna menu modulu dzielenia sekretu.
	 */
	public static int[] MenuSize = {520, 285};
	
	/**
	 * Tablica zmiennych typu int okreslajacych wymiary okna sluzacego do podzialu sekretu.
	 */
	public static int[] SecretSharingWindowSize = {520, 500};
	
	/**
	 * Tablica lancuchow znakowych okreslajacych nazwy plikow graficznych wyswietlanych w oknie sluzacym do podzialu sekretu.
	 */
	public static String[] SecretSharingButtons = {"podziel_sekret1.png", "wroc_do_menu.png", "zamknij.png", "dzielenie_sekretu_na_czesci.png", "podzial_sekretu1.png", "liczba_spadkobiercow.png", "liczba_wymagana.png"};
	
	/**
	 * Tablica lancuchow znakowych okreslajacych nazwy plikow graficznych wyswietlanych w oknach powiadomien wyswietlanych w procesie
	 * podzialu sekretu.
	 */
	public static String[] SharerNotifications = {"podzial_sekretu_blad.png", "podzial_sekretu_ok.png"};
	
	/**
	 * Zmienna typu int okreslajaca maksymalna calkowita liczbe spadkobiercow.
	 */
	public static int NumberOfSharers = 100;
	
	/**
	 * Zmienna typu int okreslajaca maksymalna potrzebna do odczytania testamentu liczbe spadkobiercow.
	 */
	public static int NumberOfSharersNeeded = 100;
	
	/**
	 * Lancuch znakowy zawierajacy nazwe pliku, w ktorym znajduje sie zaszyfrowany tekst testamentu.
	 */
	public static String TestamentFilepath = "testament_zaszyfrowany.txt";
	
	/**
	 * Zmienna bedaca wektorem tablic lancuchow znakowych numerujacych spadkobiercow.
	 * ?!
	 */
	public static Vector<String[]> SharersList = new Vector();
	
	/**
	 * Lancuch znakowy okreslajacy schemat nazywania plikow tekstowych, w ktorych zapisywane sa poszczegolne czesci sekretu.
	 */
	public static String[] SharersFilepath = {"Czesc_nr_",".txt"};
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy uruchomiony jest modul podzialu (true), czy nie (false).
	 */
	public static boolean sharer = false;
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy sekret zostal podzielony (true), czy nie (false).
	 */
	public static boolean shared = false;
	
	/**
	 * Tablica zmiennych typu int okreslajacych wymiary okna sluzacego do wysylania czesci sekretu do spadkobiercow.
	 */
	public static int[] SecretSendingWindowSize = {520,	350};
	
	/**
	 * Tablica lancuchow znakowych zawierajacych nazwy plikow graficznych wyswietlanych w oknie sluzacym do wysylania 
	 * czesci sekretu do spadkobiercow.
	 */
	public static String[] SecretSendingButtons = { "dalej.png", "zamknij.png", "rozsylanie_czesci_sekretu.png", "wpisz_e-mail_spadkobiercy.png", "wyslij_wiadomosci.png", "wpisz_e-mail_ostatniego_spadkobiercy.png", "wroc_do_menu.png"};
	
	/**
	 * Tablica lancuchow znakowych zawierajacych nazwy plikow graficznych wyswietlanych w oknach powiadomien wyswietlanych w procesie
	 * wysylania czesci sekretu do spadkobiercow.
	 */
	public static String[] SenderNotifications = {"wysylanie_wiadomosci_blad.png", "wysylanie_wiadomosci_ok.png"};
	
	/**
	 * Zmienna bedaca wektorem lancuchow znakowych bedacych adresami e-mail poszczegolnych spadkobiercow.
	 */
	public static Vector<String> MailingList = new Vector(); 
	
	/**
	 * Zmienna typu int stanowiaca licznik pozwalajacy przesuwac sie po liscie maili.
	 */
	public static int CurrentMail = 0; 
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy modul wysylania jest uruchomiony (true), czy nie (false).
	 */
	public static boolean sender = false;
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy maile zostaly wyslane (true), czy nie (false).
	 */
	public static boolean sent = false;
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy wpisywany adres e-mail jest adresem ostatniego ze spadkobiercow (true),
	 * czy nie (false).
	 */
	public static boolean last = false;
	
	/**
	 * Tablica zmiennych typu int okreslajacych wymiary okna powiadomien.
	 */
	public static int[] NotificationSize = {610,200};
	
	/**
	 * Zmienna typu boolowskiego okreslajaca, czy wiadomosci zostaly poprawnie wyslane (true),
	 * czy nie (false).
	 */
	public static boolean success = false;
	
	

}
