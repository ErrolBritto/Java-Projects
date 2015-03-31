/* 
 * File:   argsInfo.h
 * Author: Ken Clowes
 *
 * Created on July 22, 2014, 2:19 PM
 */

#ifndef ARGSINFO_H
#define	ARGSINFO_H

#ifdef	__cplusplus
extern "C" {
#endif

typedef struct {
        int argc;
        char ** argv;
} argsInfo;



#ifdef	__cplusplus
}
#endif

#endif	/* ARGSINFO_H */

