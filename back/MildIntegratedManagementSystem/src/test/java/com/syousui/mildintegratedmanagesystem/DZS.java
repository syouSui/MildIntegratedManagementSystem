package com.syousui.mildintegratedmanagesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DZS {
    static Scanner scanner = new Scanner( System.in );
    static List<Account> accountList = new ArrayList<>( );

    public static void main ( String[] args ) {
        boolean isContinue = true;
        while ( isContinue ) {
            System.out.println( "---------家庭记账软件-----------" );
            System.out.println( "         1.收支明细        " );
            System.out.println( "         2.登记收入        " );
            System.out.println( "         3.登记支出        " );
            System.out.println( "         4.退    出        " );
            System.out.print( "         请选择(1-4):" );
            String s = scanner.next( );
            switch ( s ) {
                case "1":
                    System.out.println( "收支\t\t账户金额\t\t收支金额\t\t说明" );
                    for ( Account account : accountList ) {
                        System.out.println( account.getType( ) + "\t\t" +
                                account.getNumber( ) + "\t\t" +
                                account.getType( ) + "\t\t" +
                                account.getExplanation( )
                        );
                    }
                    break;
                case "2":
                    System.out.println( "请输入账户金额.(10000以内)" );
                    int number = scanner.nextInt( );
                    boolean isContinue_2 = true;
                    while ( isContinue_2 ) {
                        if ( number > 0 && number < 10000 ) {
                            isContinue_2 = false;
                            continue;
                        }
                        System.out.println( "请输入10000以内金额." );
                        number = scanner.nextInt( );
                    }
                    System.out.println( "请输入收支金额.(10000以内)" );
                    int temp = scanner.nextInt( );
                    isContinue_2 = true;
                    while ( isContinue_2 ) {
                        if ( temp > 0 && temp < 10000 ) {
                            isContinue_2 = false;
                            continue;
                        }
                        System.out.println( "请输入10000以内金额." );
                        temp = scanner.nextInt( );
                    }
                    System.out.println( "请输入说明." );
                    String str = scanner.next( );
                    accountList.add( new Account( 0, number, temp, str ) );
                    break;
                case "3":
                    System.out.println( "请输入账户金额.(10000以内)" );
                    number = scanner.nextInt( );
                    isContinue_2 = true;
                    while ( isContinue_2 ) {
                        if ( number > 0 && number < 10000 ) {
                            isContinue_2 = false;
                            continue;
                        }
                        System.out.println( "请输入10000以内金额." );
                        number = scanner.nextInt( );
                    }
                    System.out.println( "请输入收支金额.(10000以内)" );
                    temp = scanner.nextInt( );
                    isContinue_2 = true;
                    while ( isContinue_2 ) {
                        if ( temp > 0 && temp < 10000 ) {
                            isContinue_2 = false;
                            continue;
                        }
                        System.out.println( "请输入10000以内金额." );
                        temp = scanner.nextInt( );
                    }
                    System.out.println( "请输入说明." );
                    str = scanner.next( );
                    accountList.add( new Account( 0, number, temp, str ) );
                    break;
                case "4":
                    isContinue = false;
                    break;
                default:
                    System.out.print( "请输入正确格式" );
                    break;
            }
        }

    }


    private static class Account {
        int type = 0; // 0 out & 1 in
        int temp = 0;
        int number = 0;
        String explanation = "";

        public Account ( ) {
        }
        public Account ( int type, int number, int temp, String explanation ) {
            this.type = type;
            this.number = number;
            this.temp = temp;
            this.explanation = explanation;
        }

        public String getType ( ) {
            String str = "";
            if ( type == 0 ) str = "支出";
            else if ( type == 1 ) str = "支出";
            return str;
        }
        public void setType ( String str ) {
            if ( "支出".equals( str ) ) this.type = 0;
            else if ( "支出".equals( str ) ) this.type = 1;
        }
        public int getTemp ( ) {
            return temp;
        }
        public void setTemp ( int temp ) {
            this.temp = temp;
        }
        public int getNumber ( ) {
            return number;
        }
        public void setNumber ( int number ) {
            this.number = number;
        }
        public String getExplanation ( ) {
            return explanation;
        }
        public void setExplanation ( String explanation ) {
            this.explanation = explanation;
        }
    }
}
