#include <avr/io.h>
#include <stdlib.h>
#include <util/delay.h>


void ADC_INIT(){
  DDRC = 0x00;   
  DDRD = 0xFF;
  ADCSRA = 0x87;
  ADMUX = 0x61;
  
}

int ADC_READ(){
  int Ain;
  ADCSRA |= (1<<ADSC);
  while ((ADCSRA&(1<<ADIF))==0);

  _delay_us(10);
  Ain = (int) ADCH;
  return Ain;
}


int main(int argc, char const *argv[])
{
  ADC_INIT();
  while (1)
  {
    int display = ADC_READ();
    PORTD = display;
  }
  


  return 0;
}