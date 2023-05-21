package Sprawdzian1;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Sprawdzian1.ListaOsobHelper.dodajKomponentyDoRodzica;
import static Sprawdzian1.ListaOsobHelper.ustawLokalizacje;


public class ListaOsob extends JFrame{

	private GridBagConstraints gbc = new GridBagConstraints();
	// kontener z listą abonentów
	private List<Osoba> listaOsob = new ArrayList<>();
	// obiekt wizualizujący listę
	private JList jListaOsob = new JList();
	private JButton nastepny, poprzedni;
	private static int indexOsoby = 0; //inicjalizujemy wstępnie z 0 wskazując na pierwszy element z listy

	MenuGornePanel menuGornePanel = new MenuGornePanel();
	ListaOsobPanel listaOsobPanel = new ListaOsobPanel();
	MenuBocznePanel menuBocznePanel = new MenuBocznePanel();
	OsobaJDialog osobaJDialog;

	public ListaOsob(String title) {
		super(title);
		setSize(550, 350);
		setLayout(new GridBagLayout());
		add(menuGornePanel, ustawLokalizacje(gbc,0,0));
		add(listaOsobPanel, ustawLokalizacje(gbc,0,1,2,2));
		add(menuBocznePanel, ustawLokalizacje(gbc,2,1));
		nastepny = new JButton("Nastepny");
		poprzedni = new JButton("Poprzedni");

		// dodaj poniżej obsługę przycisków 'nastepny' i 'poprzedni' (trzeba wywołać istniejące metody)



		add(poprzedni, ustawLokalizacje(gbc,3,3));
		add(nastepny, ustawLokalizacje(gbc,4,3));

		setVisible(true);
		setJMenuBar(menuGornePanel.getRootPane().getJMenuBar());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void wyswietlDaneOsobyPoKliknieciu(MouseEvent event) {
		if (event.getClickCount() == 1) {
			// dodaj obsługę, która wyświetli dane osoby po prawej stronie okna aplikacji czyli w jTextFieldach -
			// uzyj istniejacych metod i zmiennej pomocniczej
		}
	}

	public void getNastepnaOsobe(ActionEvent e){
		if (indexOsoby >= 0) {
			// ta metoda powinna nam wskazać kolejny element w JLiście oraz automatycznie wyświetlić jej dane w JTextFieldach w oknie po prawej stronie
			// uzyj istniejacych metod , a w celu sprawnego poruszania się po liście przyciskami 'Poprzedni' i 'Nastepny'

			jListaOsob.setSelectedIndex(indexOsoby); // w momencie przejścia do nowego elementu(indeksu) zaznacz w jLiście wybrany element metodą setSelectedIndex(index)
		}
	}

	public void getPoprzedniaOsobe(ActionEvent e){
		if (indexOsoby >= 0) {
			// ta metoda powinna nam wskazać poprzedni element w JLiście oraz automatycznie wyświetlić jej dane w JTextFieldach w oknie po prawej stronie
			// uzyj istniejacych metod , a w celu sprawnego poruszania się po liście przyciskami 'Poprzedni' i 'Nastepny'

			jListaOsob.setSelectedIndex(indexOsoby);
		}

	}

	public void wyswietlDaneOsobyWedlugIndeksuWPolach(int index){
		Osoba os = listaOsob.get(index);
		//dodaj poniżej logikę do wyświetlania danych znalezionej osoby w odpowiednich jTextFieldach
	}


class MenuGornePanel extends JPanel implements MenuListener {

	private JMenu jmAutor, jmAkcje, jmPlik;
	private JLabel span1, span2, span3;
	private JMenuBar mb;
	private JMenuItem dodaj,usun, edytuj, wczytajZPliku, zapiszDoPliku;

	public MenuGornePanel() {
		mb = new JMenuBar();
		jmAutor = new JMenu("O Autorze");
		jmAutor.addMenuListener(this);
		jmAkcje = new JMenu("Akcje");
		jmPlik = new JMenu("Plik");

		span1 = new JLabel("     |     ");
		span2 = new JLabel("     |     ");
		span3 = new JLabel("     |     ");

		dodaj = new JMenuItem("Dodaj");
		usun = new JMenuItem("Usuń");
		edytuj = new JMenuItem("Edytuj");
		wczytajZPliku = new JMenuItem("Wczytaj z pliku");
		zapiszDoPliku = new JMenuItem("Zapisz do pliku");

		usun.addActionListener(e -> usunUzytkownika(e));
		//poniżej dodaj 'nasłuchiwaczy' do pozostałych komponentów według wzorca powyżej (może być, ale nie musi- to taka propozycja)
		//czyli dla : dodaj, edytuj, wczytajZPliku i zapiszDoPliku
		//(z odpowiednimi metodami oczywiście)


		jmAkcje.add(dodaj);
		jmAkcje.add(usun);
		jmAkcje.add(edytuj);
		jmPlik.add(wczytajZPliku);
		jmPlik.add(zapiszDoPliku);

		mb.add(jmAutor);
		mb.add(jmAkcje);
		mb.add(jmPlik);

		dodajKomponentyDoRodzica(mb, jmAutor, span1, jmAkcje, span2, jmPlik, span3);
		setJMenuBar(mb);
	}

	public void usunUzytkownika(ActionEvent e){
		List<Osoba> osoby = listaOsob;
			int index = listaOsobPanel.getIndeksOsoby();
			if (index >= 0) {
				//usuwamy uzytkownika z listy na podstawie wskazanego indeksu
				//oraz aktualizujemy elementy w JLiście
			}

	}

	public void wczytaj(ActionEvent e){
		try {
			//dodaj obslugę wczytywania zawartości z pliku "osoby.txt" do magazynu - przy użyciu klasy-bufora

			listaOsob.clear(); // to nam czyści każdorazowo listę aby były wczytywane do niej elementy na nowo z pliku

			String osoba; //linia z pliku
			String[] daneOsoby; //tablica pomocnicza aby wrzucać do niej wartości pól imie, nazwisko,zawod z danej linii pliku

			while(true){
				//dane wczytywane linijka po linijce z pliku 'osoby.txt' trzeba przekonwertować na obiekty typu Osoba
				//sposób pozyskiwania odpowiednich wartości z pliku proszę oprzeć o aktualną strukturę danych w pliku osoby.txt,
				//gdzie kazdy obiekt zaczyna się od nowej linii a średniki oddzielają kolejne wartości pola klasy Osoba
				// tutaj na końcu dodać jeszcze zapisywanie obiektów typu Osoba do listy listaOsob
			}
			// należy po wyjściu z pętli while zaktualizować jeszcze widok elementów w JList

		} catch (Exception ie) {
			System.out.println(ie);
		}

	}
	public void zapisz(ActionEvent e){
		try {
			//dodaj obslugę zapisywania osób z listaOsob do "osoby.txt" - przy użyciu np klasy-bufora
			//trzeba przejść przez zawartość listy z osobami (listaOsob) i zapisać do utworzonego powyżej strumienia
			for (Osoba o: listaOsob) {
				//zapisujemy w formacie takim żeby linie w pliku wyglądały tak: Adam;Nowak;Kierowca - od nowej linii nowa osoba
			}
			//pamiętamy o zamknięciu strumienia

		} catch(Exception ie){
			System.out.println(ie);
		}

	}

	public void otworzOknoDoEdycjiOsoby(ActionEvent e){
		osobaJDialog = new OsobaJDialog(TypAkcji.EDYTUJ_OSOBE.getNazwa()); //implementujemy oknoJDialog w trybie edycji
		//dopisz poniżej kod ,który umożliwi wyświetlenie okna JDialog
	}

	public void otworzOknoDoDodaniaOsoby(ActionEvent e){
		osobaJDialog = new OsobaJDialog(TypAkcji.DODAJ_OSOBE.getNazwa()); //implementujemy oknoJDialog w trybie dodawania
		//dopisz poniżej kod ,który umożliwi wyświetlenie okna JDialog
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// w tym miejscu obsłuż zdarzenie pochodzące od przycisku w menu aplikacji - O Autorze
		//najlatwiej będzie poprzez użycie JOptionPane
	}

	@Override
	public void menuDeselected(MenuEvent e) {

	}

	@Override
	public void menuCanceled(MenuEvent e) {

	}
}

class ListaOsobPanel extends JPanel {

	public ListaOsobPanel() {
		// dane do testów
		listaOsob.addAll(Arrays.asList(
				new Osoba("Adam", "Nowak","Kierowca"),
				new Osoba("Jan", "Kowalski","Murarz"))
		);
		jListaOsob.setListData(listaOsob.toArray());
		jListaOsob.setPreferredSize(new Dimension(150,100));
		//ponizej dodaj obsługę kliknięć na elementy jListaOsob typu JList (implementacja MouseAdapter, w której zostanie wywołana
		// odpowiednia metoda - przygotowana wczesniej,dotycząca kliknięć )

		JScrollPane sp = new JScrollPane(jListaOsob);
		add(sp);

	}

	public int getIndeksOsoby() {
		// tutaj jedna linijka kodu (zamiast tego return 0) odpowiedzialna za zwracanie indeksu kliknietego elementu z JListy
		return 0;
	}

}

class MenuBocznePanel extends JPanel {
	private JTextField jtImie, jtNazwisko, jtZawod;
	private JLabel labelImie,labelNazwisko, labelZawod;
    private GridBagConstraints gbc =new GridBagConstraints();;

	public MenuBocznePanel() {
		setLayout(new GridBagLayout());
		labelImie = new JLabel("Imię:");
		labelNazwisko = new JLabel("Nazwisko:");
		labelZawod = new JLabel("Zawód:");
		jtImie = new JTextField(10);
		jtImie.setEditable(false);
		jtNazwisko = new JTextField(10);
		jtNazwisko.setEditable(false);
		jtZawod = new JTextField(10);
		jtZawod.setEditable(false);
		gbc.insets = new Insets(5, 5, 5, 5);
		add(labelImie, ustawLokalizacje(gbc, 0, 0));
		add(jtImie, ustawLokalizacje(gbc, 1, 0));
		add(labelNazwisko, ustawLokalizacje(gbc, 0, 1));
		add(jtNazwisko, ustawLokalizacje(gbc, 1, 1));
		add(labelZawod, ustawLokalizacje(gbc, 0, 2));
		add(jtZawod, ustawLokalizacje(gbc, 1, 2));
	}
}

class OsobaJDialog extends JDialog{
	private JTextField jtImieNowe, jtNazwiskoNowe, jtZawodNowy;
	private JLabel labelImieNowe, labelNazwiskoNowe, labelZawodNowy, tytul;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JButton zapisz, anuluj, edytuj;

	public OsobaJDialog(String title) {
		setTitle(title);
		setModal(true);
		setLayout(new GridBagLayout());

		if(title.equals(TypAkcji.EDYTUJ_OSOBE.getNazwa())){
			inicjalizujKomponenty(TypAkcji.EDYTUJ_OSOBE.getNazwa());
			Osoba o = listaOsob.get(listaOsobPanel.getIndeksOsoby());
			//w przypadku edycji osoby uzupełniamy odrazu jTextFieldy w nowym oknie JDialog
			jtImieNowe.setText(o.getImie());
			jtNazwiskoNowe.setText(o.getNazwisko());
			jtZawodNowy.setText(o.getZawod());
		}
		else {
			inicjalizujKomponenty(TypAkcji.DODAJ_OSOBE.getNazwa());
		}
		dodajKomponenty();
	}

	public void inicjalizujKomponenty(String tytulOkna){
		gbc.insets = new Insets(15,15,15,15); // ustawiamy rozmieszczenie komponentów w JDialog
		tytul = new JLabel(tytulOkna);
		tytul.setFont(new Font("Tahoma", 1, 18));
		labelImieNowe = new JLabel("Podaj imię");
		labelNazwiskoNowe = new JLabel("Podaj nazwisko");
		labelZawodNowy = new JLabel("Podaj zawód");
		jtImieNowe = new JTextField(18);
		jtNazwiskoNowe = new JTextField(18);
		jtZawodNowy = new JTextField(18);
		zapisz = new JButton("Zapisz");
		anuluj = new JButton("Anuluj");

		anuluj.addActionListener(e -> anulujButton(e));

		//dodaj poniżej obsługę przycisk 'zapisz' przy użyciu istniejącej metody do zapisu -
		// można za pomocą lambdy czyli nie implementując bezpośrednio w klasie interfejsu ActionListenera

	}

	public void dodajKomponenty(){
		add(tytul, ustawLokalizacje(gbc,0,0,1,3));
		add(labelImieNowe, ustawLokalizacje(gbc,0,2,1,1));
		add(jtImieNowe, ustawLokalizacje(gbc,1,2,1,2));
		add(labelNazwiskoNowe, ustawLokalizacje(gbc,0,3,1,1));
		add(jtNazwiskoNowe, ustawLokalizacje(gbc,1,3,1,2));
		add(labelZawodNowy, ustawLokalizacje(gbc,0,4,1,1));
		add(jtZawodNowy, ustawLokalizacje(gbc,1,4,1,2));
		add(zapisz, ustawLokalizacje(gbc,0,5,1,2));
		add(anuluj, ustawLokalizacje(gbc,1,5,1,2));
	}

	public Osoba getDaneOsoby() {
		//w poniższym konstruktorze trzeba dopisać odpowiednie wartości zczytane z JTextFieldów z okna JDialog
		return new Osoba();
	}

	private void dodajOsobe(Osoba osoba){
		//dodaj do listy nową osobę z parametru i zaktualizuj elementy w JLiście jListaOsob


		//poniżej standardowo czyścimy wczesniej wprowadzone dane
		jtImieNowe.setText("");
		jtNazwiskoNowe.setText("");
		jtZawodNowy.setText("");
	}

	//metoda zapiszOsobeButton otwiera odpowiednie okno dialogowe
	public void zapiszOsobeButton(ActionEvent e){
		Osoba osoba = getDaneOsoby(); // noew dane zczytane z okna JDialog
		if(tytul.getText().equals(TypAkcji.DODAJ_OSOBE.getNazwa())) {
			dodajOsobe(osoba);
		} else if (tytul.getText().equals(TypAkcji.EDYTUJ_OSOBE.getNazwa())) {
			int index = listaOsobPanel.getIndeksOsoby(); // w przypadku edycji pobieramy index osoby którą chcemy edytować
		 // tutaj wywołaj metodę edytującą osobę w raz z podaniem odpowiednich parametrów (dwóch)
		}
		dispose();
	}

	private void edytujOsobe(Osoba przed, Osoba po){ // zmienna przed - dane osoby przed edycją, zmienna po - nowe dane osoby aktualizowanej
		//dodaj logikę aktualizująca dane osoby ze zmiennej przed o nowe dane ze zmiennej po
	}

	public void anulujButton(ActionEvent e){
		dispose();
	}

}
	public static void main(String[] args) {
		//metoda uruchomieniowa aplikację
		new ListaOsob("test");
	}

}
