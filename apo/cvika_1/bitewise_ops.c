#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

/* Hint: You can use following command to compile this file:
 *
 * gcc bitwise_ops.c -o bitwise_ops
 *
 */

#define NUM_DEFAULT 0x1234

static uint32_t number = NUM_DEFAULT;

int main(int argc, char **argv) {
  uint32_t result;
  uint8_t mask;
  uint8_t bit;

  if (argc == 2)
    number = strtol(argv[1], NULL, 0);

  // --- THE TASK IS A BIT MISLEADING. IT SAYS FIRST 8 BITS EVEN THOUGH WE SHOULD ---
  // --- DO 8 LEAST SIGNIFICANT (THEREFORE LAST) BITS                             ---

  /* Print first 8 bits of a given number. Using %b is not allowed! */

  result = 0;
  for (int i = 7; i >= 0; i--) {
    // TODO: mask = ?
    // TODO: bit = ?
    bit = (number >> i) & 1;
    printf("%d ", bit);
    result |= bit << i;
  }
  printf("\n");

  /* Result check */
  if (result != (number & 0xff))
    printf("ERROR: result %d != %d your number.\n", result, (number & 0xff));
  else
    printf("Congratulations! Result matches.\n");

  /* Now your task is to take the previous result and set every even
   * bit to zero.
   *
   * Therefore if the previous result is
   *      1 1 1 1 1 1 1 1
   * you should get
   *      1 0 1 0 1 0 1 0
   *
   * Hint: you can do this without for loop, just with & operation
   */

  // TODO: your code goes here


  result = result & 0b10101010;
  /* Result print */
  printf("Result with even bits set to zero:\n");
  for (int i = 7; i >= 0; i--) {
    // Hint: just use your previous code
    // TODO: mask = ?
    // TODO: bit = ?
    bit = (result >> i) & 1;
    printf("%d ", bit);
  }
  printf("\n");

  return 0;
}
