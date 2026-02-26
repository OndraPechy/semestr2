#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {

  int i;
  double d = 1.1;

  // vytiskneme hodnotu promenne d
  printf("d = %.20f\n", d);

  // po provedeni vypoctu by melo byt d = 1.1
  d = 10 * d - 9.9;
  // overime to - podle ocekavani to funguje :-) (d=1.1)
  printf("d = %.20f\n", d);

  // provedeme vypocet opakovane
  printf("---\n");
  for (i = 0; i < 20; i++) {
    d = 10 * d - 9.9;
    printf("d = %.20f\n", d);
    // po case to spadne na presnost
  }

  printf("d = %.20f\n", d);

  return (EXIT_SUCCESS);
}
