package com.hou;

/**
 * @Description 抽象类
 * @Author
 * @Date 2019-09-27 11:27
 * @Version 1.0
 */
public abstract class ChouXiang {

        private String name;
        private String address;
        private int number;
   public ChouXiang(String name, String address, int number)
        {
            System.out.println("Constructing an Employee");
            this.name = name;
            this.address = address;
            this.number = number;
        }
        public double computePay()
        {
            System.out.println("Inside Employee computePay");
            return 0.0;
        }
        public void mailCheck()
        {
            System.out.println("Mailing a check to " + this.name
                    + " " + this.address);
        }
        @Override
        public String toString()
        {
            return name + " " + address + " " + number;
        }
        public String getName()
        {
            return name;
        }
        public String getAddress()
        {
            return address;
        }
        public void setAddress(String newAddress)
        {
            address = newAddress;
        }
        public int getNumber()
        {
            return number;
        }

}
