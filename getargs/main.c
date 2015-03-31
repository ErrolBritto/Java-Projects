/* 
 * File:   main.c
 * Author: Ken Clowes
 *
 * Created on July 22, 2014, 2:17 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>

#include "argsInfo.h"
extern argsInfo getArgsInfo();

int main(int argc, char** argv) {
    argsInfo info;
    int i;
    
    info = getArgsInfo("");
    assert(info.argc == 0);
    info = getArgsInfo("a");
    printf("info.argc: %d\n", info.argc);
    printf("info.argv[0] %s\n", info.argv[0]);
    assert(info.argc == 1);
    info = getArgsInfo("abc");
    printf("info.argc: %d\n", info.argc);
    for(i = 0; i < info.argc; i++) {
        printf("argv[%d]: %s\n", i, info.argv[i]);
    }
    assert(info.argc == 1);
    info = getArgsInfo("a b");
    printf("info.argc: %d\n", info.argc);
    for(i = 0; i < info.argc; i++) {
        printf("argv[%d]: %s\n", i, info.argv[i]);
    }
    assert(info.argc == 2);
    info = getArgsInfo("ax bcd efghij");
    printf("info.argc: %d\n", info.argc);
    for(i = 0; i < info.argc; i++) {
        printf("argv[%d]: %s\n", i, info.argv[i]);
    }
    assert(info.argc == 3);
    return (EXIT_SUCCESS);
}

