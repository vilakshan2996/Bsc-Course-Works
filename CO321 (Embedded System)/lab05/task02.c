#include <avr/io.h>
#include <stdlib.h>
#include <util/delay.h>
#include <Arduino.h>


void ADC_INIT(){
  DDRC = 0x00;   
  DDRD = 0x04;
  ADCSRA = 0x87;
  ADMUX = 0x41;
  
}

int ADC_READ(){
  int Ain,AinLow;
  ADCSRA |= (1<<ADSC);
  while ((ADCSRA&(1<<ADIF))==0);


  _delay_us(10);
  AinLow = (int) ADCL;
  Ain = (int) ADCH*256;
  Ain = Ain+AinLow;
  return Ain;
}


int main(int argc, char const *argv[])
{
  ADC_INIT();
  while (1)
  {
    int display = ADC_READ();
   
    if(display<500){
      PORTD = 0;
    }else{
      PORTD = 0x04;
    }
  
  }
  


  return 0;
}