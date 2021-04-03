package pl.rafalmitula;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {

    public void calculateEqualCreditInstalments() {

        // All variables names end with ECI and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnECI = new Scanner(System.in);

            System.out.println("Wprowadź kwotę udzielonego kredytu:\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountECI = scnECI.nextDouble();

            System.out.println("Wprowadź wartość wpłaty własnej:\n(W przypadku jej braku wpisz 0, a w prypadku cześci dziesiętnych oddziel je przecinkiem.)");

            double initialFeeECI = scnECI.nextDouble();

            double outstandingAmountECI = amountECI - initialFeeECI;

            System.out.println("Wprowadź okres kredytu w latach:");

            int periodECI = scnECI.nextInt();

            System.out.println("Wprowadź oprocentowanie kredytu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestECI = (scnECI.nextDouble()) / 100;

            System.out.println();

            System.out.println("Podsumowanie:");
            System.out.println(String.format("Kwota udzielonego kredytu: %.2f", amountECI) + " zł");
            System.out.println(String.format("Wpłata własna: %.2f", initialFeeECI) + " zł");
            System.out.println(String.format("Kwota kredytu po odjęciu wpłaty własnej: %.2f", outstandingAmountECI) + " zł");
            System.out.println(String.format("Oprocentowanie: %.2f", interestECI * 100) + "%");

            int numberOfRatesECI = periodECI * 12;

            double rateECI = (outstandingAmountECI * interestECI) / (12 * (1 - (Math.pow(12 / (12 + interestECI), numberOfRatesECI))));

            double totalCostOfFinancingECI = (numberOfRatesECI * rateECI);

            System.out.println(String.format("Miesięczna rata stała wyniesie: %.2f", rateECI) + " zł" + "\nOkres spłaty: " + periodECI * 12 + " miesiące/miesięcy");
            System.out.println(String.format("Całkowita kwota kredytu do spłaty (wraz z odsetkami i oprocentowaniem): %.2f", totalCostOfFinancingECI) + " zł");

        } catch (InputMismatchException e) {
            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateEqualCreditInstalments();

        }


    }

    public void calculateDecreasingCreditInstalments() {

        // All variables names end with DCI and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDCI = new Scanner(System.in);

            System.out.println("Wprowadź kwotę udzielonego kredytu:\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountDCI = scnDCI.nextDouble();

            System.out.println("Wprowadź wartość wpłaty własnej:\n(W przypadku jej braku wpisz 0, a w prypadku cześci dziesiętnych oddziel je przecinkiem.)");

            double initialFeeDCI = scnDCI.nextDouble();

            double outstandingAmountDCI = amountDCI - initialFeeDCI;

            System.out.println("Wprowadź okres kredytu w latach:");

            int periodDCI = scnDCI.nextInt();

            System.out.println("Wprowadź oprocentowanie kredytu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestDCI = (scnDCI.nextDouble()) / 100;

            System.out.println();

            int numberOfRatesDCI = periodDCI * 12;

            double ratesSumDCI = 0;

            System.out.println("Wysokość raty wynosi: ");

            for (int i = 1; i <= numberOfRatesDCI; i++) {
                double rate = ((outstandingAmountDCI / numberOfRatesDCI) * (1 + (numberOfRatesDCI - (i + 1)) * (interestDCI / numberOfRatesDCI)));
                System.out.println("Rata nr " + i + String.format(" wynosi: %.2f ", rate) + "zł");

                ratesSumDCI += rate;

            }

            double totalCostOfFinancingDCI = ratesSumDCI;
            System.out.println();
            System.out.println("Podsumowanie:");
            System.out.println(String.format("Kwota udzielonego kredytu: %.2f", amountDCI) + " zł");
            System.out.println(String.format("Wpłata własna: %.2f", initialFeeDCI) + " zł");
            System.out.println(String.format("Kwota kredytu po odjęciu wpłaty własnej: %.2f", outstandingAmountDCI) + " zł");
            System.out.println(String.format("Oprocentowanie: %.2f", interestDCI * 100) + "%");
            System.out.println("Okres spłaty: " + periodDCI * 12 + " miesiące/miesięcy");
            System.out.println(String.format("Całkowita kwota kredytu do spłaty (wraz z odsetkami i oprocentowaniem): %.2f", totalCostOfFinancingDCI) + " zł");

        } catch (InputMismatchException e) {

            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateDecreasingCreditInstalments();
        }

    }

    public void calculateEqualLeasingInstalmentsQuote() {

        // All variables names end with ELIQ and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnELIQ = new Scanner(System.in);

            System.out.println("Wprowadź wartość przedmiotu leasingu (brutto w PLN):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountELIQ = scnELIQ.nextDouble();

            System.out.println("Wprowadź wysokosć opłaty wstępnej:\n(W przypadku jej braku wpisz 0. W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double initialFeeELIQ = scnELIQ.nextDouble();

            System.out.println("Wprowadź wartość wykupu przedmiotu leasingu (brutto w PLN):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double redemptionValueELIQ = scnELIQ.nextDouble();

            System.out.println("Wprowadź oprocentowanie leasingu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestELIQ = (scnELIQ.nextDouble()) / 100;

            System.out.println("Wprowadź okres leasingu w latach:");

            int periodELIQ = scnELIQ.nextInt() * 12;

            double outstandingAmountELIQ = amountELIQ - initialFeeELIQ;

            double monthlyInterestELIQ = interestELIQ / 12;

            String roundedAmountELIQ = String.format("%.2f", amountELIQ);
            String roundedInitialFeeELIQ = String.format("%.2f", initialFeeELIQ);
            String roundedOutstandingAmountELIQ = String.format("%.2f", outstandingAmountELIQ);
            String roundedRedemptionValueELIQ = String.format("%.2f", redemptionValueELIQ);
            String roundedInterestELIQ = String.format("%.2f", interestELIQ * 100);

            System.out.println();
            System.out.println("Podsumowanie:\nWartość przedmiotu leasingu (brutto): " + roundedAmountELIQ + " zł\nOprocentowanie leasingu (w skali rocznej): " + roundedInterestELIQ + "%\nOpłata wstępna: " + roundedInitialFeeELIQ +
                    " zł\nWartość przedmiotu po odjęciu opłaty wstępnej (brutto): " + roundedOutstandingAmountELIQ + " zł\nWykup: " + roundedRedemptionValueELIQ + " zł\nOkres leasingu: " +
                    +periodELIQ + " miesiące/miesięcy");


            double rateELIQ = (outstandingAmountELIQ - (redemptionValueELIQ / (Math.pow(1 + monthlyInterestELIQ, periodELIQ)))) / ((1 - (1 / (Math.pow(1 + monthlyInterestELIQ, periodELIQ)))) / monthlyInterestELIQ);
            double taxAmountELIQ = 0.23 * rateELIQ;
            double netAmountELIQ = 0.77 * rateELIQ;
            double totalCostOfFinancingELIQ = (periodELIQ * rateELIQ) + initialFeeELIQ + redemptionValueELIQ;

            String roundedRateELIQ = String.format("%.2f", rateELIQ);
            String roundedTaxAmountELIQ = String.format("%.2f", taxAmountELIQ);
            String roundedNetAmountELIQ = String.format("%.2f", netAmountELIQ);
            String roundedTotalCostOfFinancingELIQ = String.format("%.2f", totalCostOfFinancingELIQ);

            System.out.println();
            System.out.println("Miesięczna rata wyniesie: " + roundedRateELIQ + " zł brutto\nKwota netto: " + roundedNetAmountELIQ + " zł\nPodatek VAT (23%): " + roundedTaxAmountELIQ + " zł");
            System.out.println();
            System.out.println("Całkowity koszt finansowania (Opłata wstępna + raty + wartość wykupu): " + roundedTotalCostOfFinancingELIQ + " zł");


        } catch (InputMismatchException e) {

            System.out.println("Wprowadzone dane Są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateEqualLeasingInstalmentsQuote();

        }
    }

    public void calculateEqualLeasingInstalmentsPercent() {

        // All variables names end with ELIP and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnELIP = new Scanner(System.in);

            System.out.println("Wprowadź wartość przedmiotu leasingu (brutto w PLN):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountELIP = scnELIP.nextDouble();

            System.out.println("Wprowadź procentową wysokosć opłaty wstępnej:\n(W przypadku jej braku wpisz 0. W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double initialFeeELIP = (scnELIP.nextDouble() / 100) * amountELIP;

            System.out.println("Wprowadź procentową wartość wykupu przedmiotu leasingu (brutto w PLN):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double redemptionValueELIP = (scnELIP.nextDouble() / 100) * amountELIP;

            System.out.println("Wprowadź oprocentowanie leasingu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestELIP = (scnELIP.nextDouble()) / 100;

            System.out.println("Wprowadź okres leasingu w latach:");

            int periodELIP = scnELIP.nextInt() * 12;

            double outstandingAmountELIP = amountELIP - initialFeeELIP;

            double monthlyInterestELIP = interestELIP / 12;

            double rateELIP = (outstandingAmountELIP - (redemptionValueELIP / (Math.pow(1 + monthlyInterestELIP, periodELIP)))) / ((1 - (1 / (Math.pow(1 + monthlyInterestELIP, periodELIP)))) / monthlyInterestELIP);
            double taxAmountELIP = rateELIP * 0.23;
            double netAmountELIP = rateELIP * 0.77;
            double totalCostOfFinancingELIP = (periodELIP * rateELIP) + initialFeeELIP + redemptionValueELIP;

            String roundedAmountELIP = String.format("%.2f", amountELIP);
            String roundedRateELIP = String.format("%.2f", rateELIP);
            String roundedTaxAmountELIP = String.format("%.2f", taxAmountELIP);
            String roundedNetAmountELIP = String.format("%.2f", netAmountELIP);
            String roundedTotalCostOfFinancingELIP = String.format("%.2f", totalCostOfFinancingELIP);
            String roundedInterestELIP = String.format("%.2f", interestELIP * 100);
            String roundedInitialFeeELIP = String.format("%.2f", initialFeeELIP);
            String roundedOutstandingAmountELIP = String.format("%.2f", outstandingAmountELIP);
            String roundedRedemptionValueELIP = String.format("%.2f", redemptionValueELIP);

            System.out.println();
            System.out.println("Podsumowanie");
            System.out.println("Wartość przedmiotu leasingu (brutto): " + roundedAmountELIP + " zł\nOprocentowanie leasingu (w skali rocznej): " + roundedInterestELIP + "%\nOpłata wstępna: " + roundedInitialFeeELIP
                    + " zł\nWartość przedmiotu po odjęcu opłąty wstępnej: " + roundedOutstandingAmountELIP + " zł\nWykup: " + roundedRedemptionValueELIP + " zł\nCzas trwania leasingu: " + periodELIP + " miesiące/miesięcy");
            System.out.println();
            System.out.println("Miesięczna rata wyniesie: " + roundedRateELIP + " zł brutto\nKwota netto: " + roundedNetAmountELIP + " zł\nPodatek VAT (23%): "
                    + roundedTaxAmountELIP + " zł");
            System.out.println();
            System.out.println("Całkowity koszt finansowania (Opłata wstępna + raty + wartość wykupu): " + roundedTotalCostOfFinancingELIP + " zł");

        } catch (InputMismatchException e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateEqualLeasingInstalmentsPercent();

        }

    }

    public void calculateDecrasingLeasingInstalmentsPercent() {

        // All variables names end with DLIP and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDLIP = new Scanner(System.in);

            System.out.println("Wprowadź wartość przedmiotu leasingu (brutto w zł):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountDLIP = scnDLIP.nextDouble();

            System.out.println("Wprowadź procentową wysokosć opłaty wstępnej:\n(W przypadku jej braku wpisz 0. W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double initialFeeDLIP = (scnDLIP.nextDouble() / 100) * amountDLIP;

            double outstandingAmountDLIP = amountDLIP - initialFeeDLIP;

            System.out.println("Wprowadź procentową wartość wykupu przedmiotu leasingu (brutto w zł):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double redemptionValueDLIP = (scnDLIP.nextDouble() / 100) * amountDLIP;

            System.out.println("Wprowadź oprocentowanie leasingu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestDLIP = (scnDLIP.nextDouble()) / 100;

            double monthlyInterestDLIP = interestDLIP / 12;

            System.out.println("Wprowadź okres leasingu w latach:");

            int periodDLIP = scnDLIP.nextInt() * 12;

            double mortgageDLIP = amountDLIP - initialFeeDLIP;

            double ratesSumDLIP = 0;


            for (int i = 1; i <= periodDLIP; i++) {

                double firstRateDLIP = ((amountDLIP - initialFeeDLIP - redemptionValueDLIP) / periodDLIP) + ((mortgageDLIP) * monthlyInterestDLIP);
                mortgageDLIP -= firstRateDLIP;
                double nextRateDLIP = ((amountDLIP - initialFeeDLIP - redemptionValueDLIP) / periodDLIP) + ((mortgageDLIP - firstRateDLIP) * monthlyInterestDLIP);
                double netAmountNextRateDLIP = 0.77 * nextRateDLIP;
                double taxAmountNextRateDLIP = 0.23 * nextRateDLIP;

                String roundedNextRateDLIP = String.format("%.2f", nextRateDLIP);
                String roundedNetAmountNextRateDLIP = String.format("%.2f", netAmountNextRateDLIP);
                String roundedTaxAmountNextRateDLIP = String.format("%.2f", taxAmountNextRateDLIP);

                ratesSumDLIP += nextRateDLIP;

                System.out.println();
                System.out.println("Wysokość raty nr " + i + " wynosi: " + roundedNextRateDLIP + " zł brutto\nKowta netto: " + roundedNetAmountNextRateDLIP + " zł\nPodatek VAT (23%): " + roundedTaxAmountNextRateDLIP + " zł");


            }

            System.out.println();
            double totalSumDLIP = initialFeeDLIP + ratesSumDLIP + redemptionValueDLIP;

            String roundedTotalSumDLIP = String.format("%.2f", totalSumDLIP);
            String roundedAmountDLIP = String.format("%.2f", amountDLIP);
            String roundedInitialFeeDLIP = String.format("%.2f", initialFeeDLIP);
            String roundedInterestDLIP = String.format("%.2f", interestDLIP * 100);
            String roundedOutstandingAmountDLIP = String.format("%.2f", outstandingAmountDLIP);
            String roundedRedemptionValueDLIP = String.format("%.2f", redemptionValueDLIP);

            System.out.println("Podsumowanie: ");
            System.out.println("Wartość przedmiotu leasingu (brutto): " + roundedAmountDLIP + " zł\nOprocentowanie leasingu (w skali rocznej): " + roundedInterestDLIP + "%\nOpłata wstępna: " + roundedInitialFeeDLIP
                    + " zł\nWartość przedmiotu po odjęcu opłąty wstępnej: " + roundedOutstandingAmountDLIP + " zł\nWykup: " + roundedRedemptionValueDLIP + " zł\nCzas trwania leasingu: " + periodDLIP + " miesiące/miesięcy");
            System.out.println();
            System.out.println("Całkowity koszt finansowania (Opłata wstępna + raty + wartość wykupu): " + roundedTotalSumDLIP + " zł brutto");


        } catch (InputMismatchException e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateDecrasingLeasingInstalmentsPercent();

        }

    }

    public void calculateDecreasingLeasingInstalmentsQuote() {

        // All variables names end with DLIQ and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDLIQ = new Scanner(System.in);

            System.out.println("Wprowadź wartość przedmiotu leasingu (brutto w zł):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double amountDLIQ = scnDLIQ.nextDouble();

            System.out.println("Wprowadź wysokosć opłaty wstępnej:\n(W przypadku jej braku wpisz 0. W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double initialFeeDLIQ = scnDLIQ.nextDouble();

            double outstandingAmountDLIQ = amountDLIQ - initialFeeDLIQ;

            System.out.println("Wprowadź wysokość wykupu przedmiotu leasingu (brutto w zł):\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

            double redemptionValueDLIQ = scnDLIQ.nextDouble();

            System.out.println("Wprowadź oprocentowanie leasingu:\n(Części dziesiętne oddziel przecinkiem np. Dla oprocentowania 2,76% wpisz 2,76.)");

            double interestDLIQ = (scnDLIQ.nextDouble()) / 100;

            double monthlyInterestDLIQ = interestDLIQ / 12;

            System.out.println("Wprowadź okres leasingu w latach: ");

            int periodDLIQ = scnDLIQ.nextInt() * 12;

            double mortgageDLIQ = amountDLIQ - initialFeeDLIQ;

            double ratesSumDLIQ = 0;


            for (int i = 1; i <= periodDLIQ; i++) {

                double firstRateDLIQ = ((amountDLIQ - initialFeeDLIQ - redemptionValueDLIQ) / periodDLIQ) + ((mortgageDLIQ) * monthlyInterestDLIQ);
                mortgageDLIQ -= firstRateDLIQ;
                double nextRateDLIQ = ((amountDLIQ - initialFeeDLIQ - redemptionValueDLIQ) / periodDLIQ) + ((mortgageDLIQ - firstRateDLIQ) * monthlyInterestDLIQ);
                double netAmountNextRateDLIQ = 0.77 * nextRateDLIQ;
                double taxAmountNextRateDLIQ = 0.23 * nextRateDLIQ;


                String roundedNextRateDLIQ = String.format("%.2f", nextRateDLIQ);
                String roundedNetAmountNextRateDLIQ = String.format("%.2f", netAmountNextRateDLIQ);
                String roundedTaxAmountNextRate = String.format("%.2f", taxAmountNextRateDLIQ);

                System.out.println();
                System.out.println("Wysokość raty nr " + i + " wynosi: " + roundedNextRateDLIQ + " zł brutto\nKowta netto: " + roundedNetAmountNextRateDLIQ + " zł\nPodatek VAT (23%): " + roundedTaxAmountNextRate + " zł");

                ratesSumDLIQ += nextRateDLIQ;


            }

            System.out.println();
            double totalSumDLIQ = initialFeeDLIQ + ratesSumDLIQ + redemptionValueDLIQ;

            String roundedTotalSumDLIQ = String.format("%.2f", totalSumDLIQ);
            String roundedAmountDLIQ = String.format("%.2f", amountDLIQ);
            String roundedInitialFeeDLIQ = String.format("%.2f", initialFeeDLIQ);
            String roundedInterestDLIQ = String.format("%.2f", interestDLIQ * 100);
            String roundedOutstandingAmountDLIQ = String.format("%.2f", outstandingAmountDLIQ);
            String roundedRedemptionValueDLIQ = String.format("%.2f", redemptionValueDLIQ);

            System.out.println("Podsumowanie: ");
            System.out.println("Wartość przedmiotu leasingu (brutto): " + roundedAmountDLIQ + " zł\nOprocentowanie leasingu (w skali rocznej): " + roundedInterestDLIQ + "%\nOpłata wstępna: " + roundedInitialFeeDLIQ
                    + " zł\nWartość przedmiotu po odjęcu opłąty wstępnej: " + roundedOutstandingAmountDLIQ + " zł\nWykup: " + roundedRedemptionValueDLIQ + " zł\nCzas trwania leasingu: " + periodDLIQ + " miesiące/miesięcy");
            System.out.println();


            System.out.println("Suma wszystkich opłat leasingowych wynosi: " + roundedTotalSumDLIQ + " zł brutto");


        } catch (InputMismatchException e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateDecreasingLeasingInstalmentsQuote();

        }


    }


    public void calculateDepositsInterestsMonthlyCapitalization() {

        // All variables names end with DIMC and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDIMC = new Scanner(System.in);

            System.out.println("Wprowadź początkową kwotę lokaty:");

            double startUpCapitalDIMC = scnDIMC.nextDouble();

            System.out.println("Wprowadź oprocentowanie lokaty:\n(W przypadku części dziesiętnych oddziel je przecinkiem np. dla 2,76% wpisz 2,76.)");

            double interestDIMC = scnDIMC.nextDouble() / 100;

            System.out.println("Wprowadź okres lokaty w latach:");

            int periodDIMC = scnDIMC.nextInt();

            int capitalizationDIMC = 12;

//         finalCapital = startUpCapital * Math.pow(1+(interest/ capitalization), capitalization * period*12);


            for (int i = 1; i <= periodDIMC; i++) {

                double finalCapitalDIMC = startUpCapitalDIMC * Math.pow(1 + (interestDIMC / capitalizationDIMC), capitalizationDIMC * i);
                double tax = (finalCapitalDIMC - startUpCapitalDIMC) * 0.19;
                double finalNetCapital1 = finalCapitalDIMC - tax;

                String roundedFinalCapitalDIMC = String.format("%.2f ", finalCapitalDIMC);
                String roundedTaxDIMC = String.format("%.2f ", tax);
                String roundedFinaleNetCapitalDIMC = String.format("%.2f ", finalNetCapital1);

                System.out.println("W " + i + " roku kwota lokaty wyniesie: " + roundedFinalCapitalDIMC + "zł, podatek Belki (19%) wyniesie: " + roundedTaxDIMC + "zł, kwota po odtrąceniu podatku wyniesie: " + roundedFinaleNetCapitalDIMC + "zł");

            }

        } catch (InputMismatchException e) {

            System.out.println("Wprowadzono niepoprawne dane!\nSpróbuje jeszcze raz.");
            System.out.println();
            calculateDepositsInterestsMonthlyCapitalization();
        }


    }

    public void calculateDepositsInterestQuarterlyCapitalization() {

        // All variables names end with DIQC and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDIQC = new Scanner(System.in);

            System.out.println("Wprowadź początkową kwotę lokaty:");

            double startUpCapitalDIQC = scnDIQC.nextDouble();

            System.out.println("Wprowadź oprocentowanie lokaty:\n(W przypadku części dziesiętnych oddziel je przecinkiem np. dla 2,76% wpisz 2,76.)");

            double interestDIQC = scnDIQC.nextDouble() / 100;

            System.out.println("Wprowadź okres lokaty w latach:");

            int periodDIQC = scnDIQC.nextInt();

            int capitalizationDIQC = 4;

//       finalCapital = startUpCapital * Math.pow(1+(interest/ capitalization), capitalization * period*12);


            for (int i = 1; i <= periodDIQC; i++) {

                double finalCapitalDIQC = startUpCapitalDIQC * Math.pow(1 + (interestDIQC / capitalizationDIQC), capitalizationDIQC * i);
                double taxDIQC = (finalCapitalDIQC - startUpCapitalDIQC) * 0.19;
                double finalNetCapitalDIQC = finalCapitalDIQC - taxDIQC;

                String roundedFinalCapitalDIQC = String.format("%.2f ", finalCapitalDIQC);
                String roundedTaxDIQC = String.format("%.2f ", taxDIQC);
                String roundedFinaleNetCapitalDIQC = String.format("%.2f ", finalNetCapitalDIQC);

                System.out.println("W " + i + " roku kwota lokaty wyniesie: " + roundedFinalCapitalDIQC + "zł, podatek Belki (19%) wyniesie: " + roundedTaxDIQC + "zł, kwota po odtrąceniu podatku wyniesie: " +
                        roundedFinaleNetCapitalDIQC + "zł");
            }
        } catch (InputMismatchException e) {

            System.out.println("Wprowadzono niepoprawne dane!\nSpróbuje jeszcze raz.");
            System.out.println();
            calculateDepositsInterestQuarterlyCapitalization();


        }
    }


    public void calculateDepositsInterestSemiannualCapitalization() {

        // All variables names end with DISC and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnDISC = new Scanner(System.in);

            System.out.println("Wprowadź początkową kwotę lokaty:");

            double startUpCapitalDISC = scnDISC.nextDouble();

            System.out.println("Wprowadź oprocentowanie lokaty:\n(W przypadku części dziesiętnych oddziel je przecinkiem np. dla 2,76% wpisz 2,76.)");

            double interestDISC = scnDISC.nextDouble() / 100;

            System.out.println("Wprowadź okres lokaty w latach:");

            int periodDISC = scnDISC.nextInt();

            int capitalizationDISC = 2;

//        double finalCapital = startUpCapital * Math.pow(1+(interest/ capitalization), capitalization * period*12);


            for (int i = 1; i <= periodDISC; i++) {

                double finalCapitalDISC = startUpCapitalDISC * Math.pow(1 + (interestDISC / capitalizationDISC), capitalizationDISC * i);
                double taxDISC = (finalCapitalDISC - startUpCapitalDISC) * 0.19;
                double finalNetCapitalDISC = finalCapitalDISC - taxDISC;

                String roundedFinalCapitalDISC = String.format("%.2f ", finalCapitalDISC);

                String roundedTaxDISC = String.format("%.2f ", taxDISC);
                String roundedFinaleNetCapitalDISC = String.format("%.2f ", finalNetCapitalDISC);

                System.out.println("W " + i + " roku kwota lokaty wyniesie: " + roundedFinalCapitalDISC + "zł, podatek Belki (19%) wyniesie: " + roundedTaxDISC + "zł, kwota po odtrąceniu podatku wyniesie: " +
                        roundedFinaleNetCapitalDISC + "zł");

            }
        } catch (InputMismatchException e) {

            System.out.println("Wprowadzono niepoprawne dane.\nSpróbuje jeszcze raz!");
            System.out.println();
            calculateDepositsInterestSemiannualCapitalization();
        }
    }

    public void calculateProfitOnShares() {

        // All variables names end with POS and it comes from the name of the method (without "calculate" word)

        try {

            Scanner scnPOS = new Scanner(System.in);

            System.out.println("Wprowadź liczbę akcji:");

            int sharesAmountPOS = scnPOS.nextInt();

            System.out.println("Wprowadź cenę kupna akcji:");

            double purchasePricePOS = scnPOS.nextDouble();

            System.out.println("Podaj cenę sprzedaży akcji:");

            double sellingPricePOS = scnPOS.nextDouble();

            System.out.println("Wprowadź wysokość prowizji biura maklerskiego.\n(Części dziesiętne oddziel przecinkiem np. dla prowizji 3,50% wpisz 3,50.)");

            double commissionPOS = scnPOS.nextDouble() / 100;

            double profitPOS = (sharesAmountPOS * sellingPricePOS) - (sharesAmountPOS * purchasePricePOS);

            double multiplyCommissionPOS = commissionPOS * 100;


            double totalBuyingPricePOS = sharesAmountPOS * purchasePricePOS;
            double totalSellingPricePOS = sharesAmountPOS * sellingPricePOS;
            double purchaseCommissionPOS = commissionPOS * sharesAmountPOS * purchasePricePOS;
            double sellingCommissionPOS = commissionPOS * sharesAmountPOS * sellingPricePOS;
            double totalCommissionPOS = purchaseCommissionPOS + sellingCommissionPOS;
            double profitAfterCommissionPOS = profitPOS - totalCommissionPOS;
            double taxAmountPOS = 0.19 * profitAfterCommissionPOS;
            double netProfitPOS = profitAfterCommissionPOS - taxAmountPOS;

            String roundedTotalBuyingPricePOS = String.format("%.2f ", totalBuyingPricePOS);
            String roundedTotalSellingPricePOS = String.format("%.2f ", totalSellingPricePOS);
            String roundedProfitPOS = String.format("%.2f ", profitPOS);
            String roundedPurchaseCommissionPOS = String.format("%.2f ", purchaseCommissionPOS);
            String roundedSellingCommissionPOS = String.format("%.2f ", sellingCommissionPOS);
            String roundedTotalCommissionPOS = String.format("%.2f", totalCommissionPOS);
            String roundedProfitAfterCommissionPOS = String.format("%.2f ", profitAfterCommissionPOS);
            String rondedTaxAmountPOS = String.format("%.2f ", taxAmountPOS);
            String roundedNetProfitPOS = String.format("%.2f", netProfitPOS);
            String roundedPurchasePricePOS = String.format("%.2f", purchasePricePOS);
            String roundeSellingPricePOS = String.format("%.2f", sellingPricePOS);
            String roundedMultiplyCommissionPOS = String.format("%.2f", multiplyCommissionPOS);

            System.out.println();
            System.out.println("Podsumowanie:" + "\nLiczba akcji: " + sharesAmountPOS + "\nCena kupna 1 akcji: " + roundedPurchasePricePOS + " zł\nCena sprzedaży 1 akcji: " + roundeSellingPricePOS + " zł\nCałkowita cena kupna: " + roundedTotalBuyingPricePOS + "zł (" + sharesAmountPOS + " akcji po " + purchasePricePOS + " zł za 1 szt.)"
                    + "\nCałkowita cena sprzedaży: " + roundedTotalSellingPricePOS + "zł (" + sharesAmountPOS + " akcji po " + sellingPricePOS + " zł za 1 szt.) ");
            System.out.println("Zysk/Strata przed odjęciem prowizji i opodatkowaniem: " + roundedProfitPOS + "zł (" + roundedTotalSellingPricePOS + "zł - " + roundedTotalBuyingPricePOS + "zł)");


            if (profitPOS > 0) {

                System.out.println("Prowizja od buria maklerskiego " + "(" + roundedMultiplyCommissionPOS + "%): " + roundedTotalCommissionPOS + " zł (W tym prowizja od kupna: " + roundedPurchaseCommissionPOS
                        + "zł i prowizja od sprzedaży: " + roundedSellingCommissionPOS + "zł)" + "\nZysk po odjęciu prowizji: " + roundedProfitAfterCommissionPOS + "zł\nKwota podatku Belki (19%): " + rondedTaxAmountPOS + "zł\nZysk netto: " + roundedNetProfitPOS + " zł");


            } else if (profitPOS < 0) {

                System.out.println("Twoja strata wynosi: " + roundedProfitPOS + "zł");

            } else if (profitPOS == 0) {
                System.out.println("Nic nie zarobiłeś/aś, ale też nic nie straciłeś/aś.\nTwój zysk wynosi 0,00.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateProfitOnShares();

        }

    }


    public void calculateGrossVat23() {

        // All variables names end with GV23 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć VAT 23%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnGV23 = new Scanner(System.in);
            double amountGrossGV23 = scnGV23.nextDouble();
            double amountVatGV23 = (amountGrossGV23 * 0.23) / (1.23);
            double amountNetGV23 = (amountGrossGV23 / (123)) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGV23) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGV23) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatGV23) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateGrossVat23();
        }


    }

    public void calculateGrossVat8() {

        // All variables names end with GV8 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć VAT 8%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnGV8 = new Scanner(System.in);
            double amountGrossGV8 = scnGV8.nextDouble();
            double amountVatGV8 = (amountGrossGV8 * 0.08) / (1.08);
            double amountNetGV8 = (amountGrossGV8 / (108)) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGV8) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGV8) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatGV8) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateGrossVat8();
        }

    }

    public void calculateGrossVat5() {

        // All variables names end with GV5 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć VAT 5%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnGV5 = new Scanner(System.in);
            double amountGrossGV5 = scnGV5.nextDouble();
            double amountVatGV5 = (amountGrossGV5 * 0.05) / (1.05);
            double amountNetGV5 = (amountGrossGV5 / (105)) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGV5) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGV5) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatGV5) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateGrossVat5();

        }

    }

    public void calculateNetVat23() {

        // All variables names end with NV23 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć VAT 23%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnNV23 = new Scanner(System.in);
            double amountNetNV23 = scnNV23.nextDouble();
            double amountVatNV23 = amountNetNV23 * 0.23;
            double amountGrossNV23 = amountNetNV23 * 1.23;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNV23) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNV23) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatNV23) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateNetVat23();

        }

    }

    public void calculateNetVat8() {

        // All variables names end with NV8 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć VAT 8%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnNV8 = new Scanner(System.in);
            double amountNetNV8 = scnNV8.nextDouble();
            double amountVatNV8 = amountNetNV8 * 0.08;
            double amountGrossNV8 = amountNetNV8 * 1.08;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNV8) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNV8) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatNV8) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateNetVat8();

        }

    }

    public void calculateNetVat5() {

        // All variables names end with NV5 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć VAT 5%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnNV5 = new Scanner(System.in);
            double amountNetNV5 = scnNV5.nextDouble();
            double amountVatNV5 = amountNetNV5 * 0.05;
            double amountGrossNV5 = amountNetNV5 * 1.05;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNV5) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNV5) + " zł");
            System.out.println(String.format("Kwota podatku VAT: %.2f", amountVatNV5) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są niepoprawne!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculateNetVat5();

        }

    }

    public void calculateNetCit19() {

        // All variables names end with NC19 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć CIT 19%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {
            Scanner scnNC19 = new Scanner(System.in);
            double amountNetNC19 = scnNC19.nextDouble();
            double amountTaxNC19 = amountNetNC19 * 0.19;
            double amountGrossNC19 = amountNetNC19 * 1.19;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNC19) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNC19) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxNC19) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróuj jeszcze raz.");
            System.out.println();
            calculateNetCit19();

        }

    }

    public void calculateNetCit9() {

        // All variables names end with NC9 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć CIT 9%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {
            Scanner scnNC9 = new Scanner(System.in);
            double amountNetNC9 = scnNC9.nextDouble();
            double amountTaxNC9 = amountNetNC9 * 0.09;
            double amountGrossNC9 = amountNetNC9 * 1.09;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNC9) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNC9) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxNC9) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróuj jeszcze raz.");
            System.out.println();
            calculateNetCit9();

        }

    }

    public void calculateNetCit5() {

        // All variables names end with NC5 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę netto od jakiej chcesz obliczyć CIT 5%:" + "\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {
            Scanner scnNC5 = new Scanner(System.in);
            double amountNetNC5 = scnNC5.nextDouble();
            double amountTaxNC5 = amountNetNC5 * 0.05;
            double amountGrossNC5 = amountNetNC5 * 1.05;

            System.out.println(String.format("Kwota netto: %.2f", amountNetNC5) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossNC5) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxNC5) + " zł");

        } catch (Exception e) {

            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróuj jeszcze raz.");
            System.out.println();
            calculateNetCit5();

        }

    }

    public void calculateGrossCit19() {

        // All variables names end with GC19 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć CIT 19%:" + "\n(W przypadku części dziesiętnych odddziel je przecinkiem.)");

        try {

            Scanner scnGC19 = new Scanner(System.in);
            double amountGrossGC19 = scnGC19.nextDouble();
            double amountTaxGC19 = (amountGrossGC19 * 0.19) / 1.19;
            double amountNetGC19 = (amountGrossGC19 / 119) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGC19) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGC19) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxGC19) + " zł");

        } catch (Exception e) {
            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
        }
    }

    public void calculateGrossCit9() {

        // All variables names end with GC9 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć CIT 9%:" + "\n(W przypadku części dziesiętnych odddziel je przecinkiem.)");

        try {

            Scanner scnGC9 = new Scanner(System.in);
            double amountGrossGC9 = scnGC9.nextDouble();
            double amountTaxGC19 = (amountGrossGC9 * 0.09) / 1.09;
            double amountNetGC19 = (amountGrossGC9 / 109) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGC19) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGC9) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxGC19) + " zł");

        } catch (Exception e) {
            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
        }
    }

    public void calculateGrossCit5() {

        // All variables names end with GC5 and it comes from the name of the method (without "calculate" word)

        System.out.println("Podaj kwotę brutto od jakiej chcesz obliczyć CIT 5%:" + "\n(W przypadku części dziesiętnych odddziel je przecinkiem.)");

        try {

            Scanner scnGC5 = new Scanner(System.in);
            double amountGrossGC5 = scnGC5.nextDouble();
            double amountTaxGC5 = (amountGrossGC5 * 0.05) / 1.05;
            double amountNetGC5 = (amountGrossGC5 / 105) * 100;

            System.out.println(String.format("Kwota netto: %.2f", amountNetGC5) + " zł");
            System.out.println(String.format("Kwota brutto: %.2f", amountGrossGC5) + " zł");
            System.out.println(String.format("Kwota podatku CIT: %.2f", amountTaxGC5) + " zł");

        } catch (Exception e) {
            System.out.println("Wprowadzone dane są nieprawidłowe!\nSpróbuj jeszcze raz.");
        }
    }

    public void calculatePit() {

        // All variables names end with Pit and it comes from the name of the method (without "calculate" word)

        System.out.println("Wprowadź wysokość twojego rocznego dochodu:\n(W przypadku części dziesiętnych oddziel je przecinkiem.)");

        try {

            Scanner scnPit = new Scanner(System.in);
            double amountPit = scnPit.nextDouble();
            String roundedPitAmount = String.format("%.2f", amountPit);

            if (amountPit <= 8000) {

                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("Kwota do 8000 zł jest wolna od podatku.\n(Dotyczy to jednak tylko podatników, którzy rozliczają się na zasadach ogólnych, według progresywnej skali podatkowej.)");

            } else if (amountPit > 8000 && amountPit <= 13000) {

                System.out.println("W przypadku dochodu rocznego w przedziale od ponad 8000 zł do 13 000 zł, wysokość podatku PIT wynosi 17% rocznego dochodu pomniejszone o wysokość kwoty zmniejszającej podatek.\nKwota zmniejsząca podatek " +
                        "jest wyliczana według wzoru: 1360 zł - ((834,88 zł * (podstawa obliczenia podatku - 8000 zł)/5000 zł).");

                double reducedAmoun8000To13000Pit = 1360 - ((834.88 * (amountPit - 8000)) / 5000);
                double taxAmount8000To13000Pit = (amountPit * 0.17) - reducedAmoun8000To13000Pit;

                String roundedReducedAmount8000To13000Pit = String.format("%.2f", reducedAmoun8000To13000Pit);
                String roundedTaxAmount8000To13000Pit = String.format("%.2f", taxAmount8000To13000Pit);

                System.out.println();
                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("Kwota zmniejszająca podatek (1360 zł - ((834,88 zł * (podstawa obliczenia podatku - 8000 zł)/5000 zł): " + roundedReducedAmount8000To13000Pit + " zł");
                System.out.println("Kwota podatku PIT (17% wartości rocznego dochodu pomniejszone o kwotę zmniejszającą podatek): " + roundedTaxAmount8000To13000Pit + " zł");

            } else if (amountPit > 13000 && amountPit <= 85528) {
                System.out.println("W przypadku dochodu rocznego w przedziale od ponad 13 000 zł do 85 528 zł, wysokość podatku PIT wynosi 17% rocznego dochodu pomniejszone o wysokość kwoty zmniejszającej podatek.\nKwota zmniejszająca podatek" +
                        " jest w tym przedziale stała i wynosi 525,12 zł.");

                double reducedAmount13000To85528Pit = 525.12;
                double taxAmount13000To85528Pit = ((amountPit * 0.17) - reducedAmount13000To85528Pit);

                String roundedReducedAmount13000To85528Pit = String.format("%.2f", reducedAmount13000To85528Pit);
                String roundedTaxAmount13000To85528Pit = String.format("%.2f", taxAmount13000To85528Pit);

                System.out.println();
                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("Kwota zmniejszająca podatek (w tym przedziale dochodu wartość jest stała): " + roundedReducedAmount13000To85528Pit + " zł");
                System.out.println("Kwota podatku PIT (17% wartości rocznego dochodu pomniejszone o 525,12 zł): " + roundedTaxAmount13000To85528Pit + " zł");


            } else if (amountPit > 85528 && amountPit <= 127000) {

                System.out.println("W przypadku dochodu rocznego w przedziale od ponad 85 528 zł do 127 000 zł, wysokość podatku PIT wynosi 14 539,76 zł + 32% nadwyżki powyżej 85 528 zł pomniejszone o wysokość kwoty zmniejszającej podatek.\nKwota zmniejsząca podatek " +
                        "jest wyliczana według wzoru: 525,12zł - ((525,12 zł * (podstawa obliczenia podatku - 85528 zł)/41 472 zł).");

                double reducedAmount85528To127000Pit = 525.12 - ((525.12 * (amountPit - 85528)) / 41472);
                double taxAmount85528To127000Pit = (14539.76 + ((amountPit - 85528) * 0.32)) - reducedAmount85528To127000Pit;

                String roundedReducedAmount85528To127000Pit = String.format("%.2f", reducedAmount85528To127000Pit);
                String roundedTaxAmount85528To127000Pit = String.format("%.2f", taxAmount85528To127000Pit);

                System.out.println();
                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("Kwota zmniejszająca podatek (525,12zł - ((525,12 zł * (podstawa obliczenia podatku - 85 528 zł)/41 472 zł)): " + roundedReducedAmount85528To127000Pit + " zł");
                System.out.println("Kwota podatku PIT (14 539,76 zł + 32% nadwyżki powyżej 85 528 zł - kwota zmniejszająca podatek): " + roundedTaxAmount85528To127000Pit + " zł");


            } else if (amountPit > 127000 && amountPit <= 1000000) {

                System.out.println("W przypadku dochodu rocznego w przedziale od ponad 127 000 zł do 1 000 000 zł, wysokość podatku PIT wynosi 14 539,76 zł + 32% nadwyżki powyżej 85 528 zł." +
                        "\nW tym przedziale nie występuje kwota zmniejszająca podatek.");

                double taxAmount127000To1000000Pit = (14539.76 + ((amountPit - 85528) * 0.32));

                String roundedTaxAmoun127000To1000000Pit = String.format("%.2f", taxAmount127000To1000000Pit);

                System.out.println();
                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("Kwota podatku PIT (14 539,76 zł + 32% nadwyżki powyżej 85 528 zł): " + roundedTaxAmoun127000To1000000Pit + " zł");

            } else if (amountPit > 1000000) {

                System.out.println("W przypadku dochodu rocznego powyżej 1 000 000 zł, wysokość podatku PIT wynosi 14 539,76 zł + 32% nadwyżku powyżej 85 528 zł + 4% nadwyżki powyżej 1 000 000 zł." +
                        "\nW tym przedziale nie występuje kwota zmniejszająca podatek.");

                double taxAmountOver85528Pit = 0.32 * (amountPit - 85528);
                double taxAmountOver1000000Pit = 0.04 * (amountPit - 1000000);
                double totalTaxAmountOver1000000Pit = 14539.76 + taxAmountOver85528Pit + taxAmountOver1000000Pit;

                String roundedTaxAnountOver85528Pit = String.format("%.2f", taxAmountOver85528Pit);
                String roundedTaxAnountOver1000000Pit = String.format("%.2f", taxAmountOver1000000Pit);
                String roundedTotalTaxAmountOver1000000Pit = String.format("%.2f", totalTaxAmountOver1000000Pit);

                System.out.println();
                System.out.println("Podstawa do obliczenia podatku: " + roundedPitAmount + " zł");
                System.out.println("1 część składowa podatku PIT (32% nadwyżki powyżej 85 528 zł): " + roundedTaxAnountOver85528Pit + " zł");
                System.out.println("2 część składowa podatku PIT (4% nadwyżki powyżej 1 000 000 zł): " + roundedTaxAnountOver1000000Pit + " zł");
                System.out.println("Kwota podatku PIT (14 539,76 + 1 część składowa + 2 część składowa): " + roundedTotalTaxAmountOver1000000Pit + " zł");

            }

        } catch (Exception e) {
            System.out.println("Wprowadzono niepoprawne dane!\nSpróbuj jeszcze raz.");
            System.out.println();
            calculatePit();
        }


    }
}
