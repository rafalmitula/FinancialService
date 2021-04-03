package pl.rafalmitula;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static boolean shouldContinue = true;
    private static Scanner scn = new Scanner(System.in);
    private static Methods methods = new Methods();

    public static void main(String[] args) {

        System.out.println("ObLiczanie raty kredytu, Obliczanie raty leasingu, Obliczanie odsetek z lokaty");

        while (shouldContinue) {

            System.out.println();
            System.out.println("1. Kredyt\n2. Leasing\n3. Lokata\n4. Akcje\n5. Rozliczanie podatku VAT\n6. Rozliczanie podatku CIT\n7. Rozliczanie podatku PIT\n8. Wyjście");


            try {
                int userChoice = scn.nextInt();

                switch (userChoice) {

                    case 1 -> {

                        boolean shouldContinueCredit = true;

                        while (shouldContinueCredit) {

                            try {

                                System.out.println();
                                System.out.println("Wybierz opcję:\n1. Rata stała\n2. Rata malejąca\n3. Powrót do menu głównego");

                                int userChoiceCredit = scn.nextInt();

                                switch (userChoiceCredit) {
                                    case 1 -> methods.calculateEqualCreditInstalments();
                                    case 2 -> methods.calculateDecreasingCreditInstalments();
                                    case 3 -> shouldContinueCredit = false;
                                    default -> {
                                        System.out.println("Błąd wprowazdzania!\nWybierz opcję od 1 do 3.");
                                        {

                                        }
                                    }
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponownie.");
                                scn.next();
                            }

                        }
                    }

                    case 2 -> {

                        boolean shouldContinueLeasing = true;

                        while (shouldContinueLeasing) {

                            try {
                                System.out.println();
                                System.out.println("Wybierz opcję:\n1. Rata stała - kwotowo\n2. Rata stała - procentowo\n3. Rata malejaca - kwotowo\n4. Rata malejąca - procentowo\n5. Powrót do menu głównego");

                                int userChoiceLeasing = scn.nextInt();

                                switch (userChoiceLeasing) {
                                    case 1 -> methods.calculateEqualLeasingInstalmentsQuote();
                                    case 2 -> methods.calculateEqualLeasingInstalmentsPercent();
                                    case 3 -> methods.calculateDecreasingLeasingInstalmentsQuote();
                                    case 4 -> methods.calculateDecrasingLeasingInstalmentsPercent();
                                    case 5 -> shouldContinueLeasing = false;
                                    default -> {
                                        System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 5.");
                                        {
                                        }
                                    }
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                                scn.next();
                            }

                        }
                    }

                    case 3 -> {

                        boolean shouldContinueDeposit = true;

                        while (shouldContinueDeposit) {

                            try {

                                System.out.println();
                                System.out.println("Wybierz opcję:\n1. Lokata z kapitalizacją miesięczną\n2. Lokata z kapitalizacją kwartalną\n3. Lokata z kapitalizacją półroczną\n4. Powrót");

                                int userChoiceDeposit = scn.nextInt();

                                switch (userChoiceDeposit) {
                                    case 1 -> methods.calculateDepositsInterestsMonthlyCapitalization();
                                    case 2 -> methods.calculateDepositsInterestQuarterlyCapitalization();
                                    case 3 -> methods.calculateDepositsInterestSemiannualCapitalization();
                                    case 4 -> shouldContinueDeposit = false;
                                    default -> {
                                        System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 4.");
                                    }
                                }


                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                                scn.next();
                            }

                        }

                    }

                    case 4 -> {

                        boolean shouldContinueStock = true;

                        while (shouldContinueStock) {

                            System.out.println("1. Oblicz zysk z akcji");
                            System.out.println("2. Powrót do menu głównego");

                            try {

                                int userChoiceStock = scn.nextInt();
                                switch (userChoiceStock) {

                                    case 1 -> methods.calculateProfitOnShares();
                                    case 2 -> shouldContinueStock = false;
                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 2.");
                                }


                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponowne. ");
                                scn.next();
                            }

                        }

                    }

                    case 5 -> {

                        boolean shouldContinueVat = true;

                        while (shouldContinueVat) {

                            System.out.println();
                            System.out.println("Wybierz opcję: ");
                            System.out.println("1. Rozlicz VAT - kwota brutto");
                            System.out.println("2. Rozlicz VAT - kwota netto");
                            System.out.println("3. Powrót do menu głównego");


                            try {

                                int userChoiceVat = scn.nextInt();

                                switch (userChoiceVat) {

                                    case 1 -> {

                                        boolean shouldContinueGrossVat = true;

                                        while (shouldContinueGrossVat) {
                                            System.out.println();
                                            System.out.println("Wybierz opcję:\n1. 23%\n2. 8%\n3. 5%\n4. Powrót do menu");

                                            try {

                                                int userChoiceGrossVat = scn.nextInt();

                                                switch (userChoiceGrossVat) {

                                                    case 1 -> methods.calculateGrossVat23();
                                                    case 2 -> methods.calculateGrossVat8();
                                                    case 3 -> methods.calculateGrossVat5();
                                                    case 4 -> shouldContinueGrossVat = false;
                                                    default -> {
                                                        System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 4.");
                                                        {

                                                        }
                                                    }

                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponowne. ");
                                                scn.next();
                                            }

                                        }
                                    }

                                    case 2 -> {

                                        boolean shouldContinueNetVat = true;

                                        while (shouldContinueNetVat) {
                                            System.out.println();
                                            System.out.println("Wybierz opcję:\n1. 23%\n2. 8%\n3. 5%\n4. Powrót do menu");

                                            try {

                                                int userChoiceNetVat = scn.nextInt();

                                                switch (userChoiceNetVat) {

                                                    case 1 -> methods.calculateNetVat23();
                                                    case 2 -> methods.calculateNetVat8();
                                                    case 3 -> methods.calculateNetVat5();
                                                    case 4 -> shouldContinueNetVat = false;
                                                    default -> {
                                                        System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 4.");
                                                        {

                                                        }
                                                    }
                                                }


                                            } catch (InputMismatchException e) {
                                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponownie.");
                                                scn.next();
                                            }
                                        }
                                    }
                                    case 3 -> shouldContinueVat = false;
                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 3.");


                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                                scn.next();
                            }

                        }

                    }

                    case 6 -> {

                        boolean shouldContinueCit = true;

                        while (shouldContinueCit) {

                            System.out.println();
                            System.out.println("Wybierz opcję: ");
                            System.out.println("1. Rozlicz CIT - kwota brutto");
                            System.out.println("2. Rozlicz CIT - kwota netto");
                            System.out.println("3. Wyjście do menu głównego");


                            try {

                                int userChoiceCit = scn.nextInt();

                                switch (userChoiceCit) {

                                    case 1 -> {

                                        boolean shouldContinueCitGross = true;

                                        while (shouldContinueCitGross) {

                                            System.out.println();
                                            System.out.println("Wybierz opcję:\n1. 19%\n2. 9%\n3. 5%\n4. Powrót do menu");

                                            try {

                                                int userChoiceGrossCit = scn.nextInt();

                                                switch (userChoiceGrossCit) {

                                                    case 1 -> methods.calculateGrossCit19();
                                                    case 2 -> methods.calculateGrossCit9();
                                                    case 3 -> methods.calculateGrossCit5();
                                                    case 4 -> shouldContinueCitGross = false;
                                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 3.");

                                                }

                                            } catch (InputMismatchException e) {
                                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponownie.");
                                                scn.next();

                                            }
                                        }

                                    }

                                    case 2 -> {

                                        boolean shouldContinueCitNet = true;

                                        while (shouldContinueCitNet) {

                                            System.out.println();
                                            System.out.println("Wybierz opcję:\n1. 19%\n2. 9%\n3. 5%\n4. Powrót do menu");

                                            try {

                                                int userChoiceNetCit = scn.nextInt();

                                                switch (userChoiceNetCit) {
                                                    case 1 -> methods.calculateNetCit19();
                                                    case 2 -> methods.calculateNetCit9();
                                                    case 3 -> methods.calculateNetCit5();
                                                    case 4 -> shouldContinueCitNet = false;
                                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 3.");

                                                }

                                            } catch (InputMismatchException e) {
                                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj ponownie.");
                                                scn.next();
                                            }


                                        }

                                    }
                                    case 3 -> shouldContinueCit = false;
                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 3.");

                                }


                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                                scn.next();

                            }


                        }

                    }

                    case 7 -> {

                        boolean shouldContinuePit = true;

                        while (shouldContinuePit) {

                            System.out.println();
                            System.out.println("Wybierz opcję: ");
                            System.out.println("1. Rozlicz podatek PIT");
                            System.out.println("2. Powrót do menu głównego");


                            try {

                                int userChoicePit = scn.nextInt();

                                switch (userChoicePit) {
                                    case 1 -> methods.calculatePit();
                                    case 2 -> shouldContinuePit = false;
                                    default -> System.out.println("Błąd wprowadzania!\nWybierz opcję od 1 do 2.");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                                scn.next();
                            }

                        }

                    }
                    case 8 -> shouldContinue = false;
                    default -> System.out.println("Wprowadzono niepoprawne dane!\nWybierz opcję od 1 do 8.");

                }
            } catch (Exception e) {
                System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
                scn.next();
            }

        }

    }
}

