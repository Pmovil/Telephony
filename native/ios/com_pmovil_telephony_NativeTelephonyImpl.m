/*
 * The MIT License
 *
 * Copyright 2015 Pmovil LTDA.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
#import "com_pmovil_telephony_NativeTelephonyImpl.h"

@implementation com_pmovil_telephony_NativeTelephonyImpl

-(void)load{
    netInfo = [[CTTelephonyNetworkInfo alloc] init];
    carrier = [netInfo subscriberCellularProvider];
}

-(NSString*)getMcc{
    if (carrier == nil) {
        return nil;
    }
    return [carrier mobileCountryCode];
}

-(NSString*)getMnc{
    if (carrier == nil) {
        return nil;
    }
    return [carrier mobileNetworkCode];
}

-(NSString*)getIsoCountryCode{
    if (carrier == nil) {
        return nil;
    }
    return [carrier isoCountryCode];
}

-(NSString*)getCarrierName{
    if (carrier == nil) {
        return nil;
    }
    return [carrier carrierName];
}

-(BOOL)isSupported{
    return YES;
}

@end