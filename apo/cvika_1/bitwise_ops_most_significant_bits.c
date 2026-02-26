#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

/* Hint: You can use following command to compile this file:
 *
 * gcc bitwise_ops.c -o bitwise_ops
 *
 */

#define NUM_DEFAULT 0xF3000000

static uint32_t number = NUM_DEFAULT;

int main(int argc, char **argv) {
  uint32_t result;
  uint8_t mask;
  uint8_t bit;

  if (argc == 2)
    number = strtol(argv[1], NULL, 0);

  /* PRINT 8 MOST SIGNIFICANT BITS OF UINT32_T NUMBER */

  result = 0;
  for (int i = 7; i >= 0; i--) {

    bit = (number >> (i + 24)) & 1; // 24 because I want 8 most significant
    printf("%d ", bit);
    result |= bit << i;
  }
  printf("\n");

  /* Result check */
  if (result != ((number >> 24) & 0xff)) // could also be
    printf("ERROR: result %d != %d your number.\n", result, ((number >> 24) & 0xff));
  else
    printf("Congratulations! Result matches.\n");

  printf("%d\n", result);

  result = result & 0b10101010;
  printf("Result with even bits set to zero:\n");
  for (int i = 7; i >= 0; i--) {
    bit = (result >> i) & 1;
    printf("%d ", bit);
  }
  printf("\n");

  return 0;
}
