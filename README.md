# Encoder

## Encode

Takes in string, generate a random key and use it as a offset to the characters.

The key is appended to the first character of the string.

e.g. 'HELLO WORLD' -> 'BGDKKN VNQKC'

## Decode

Takes in the encoded text, where the first character is the key.

e.g. 'BGDKKN VNQKC' -> 'HELLO WORLD', the key is 'B'
