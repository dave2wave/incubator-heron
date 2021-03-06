/*
 * Copyright 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#if !defined(__ERROR_MODULE_INIT_H)
#define __ERROR_MODULE_INIT_H

#include "basics/sptypes.h"

class __nifty_error_modinit {
 public:
  __nifty_error_modinit();
  ~__nifty_error_modinit();

 private:
  static sp_int32 count_;
};

static __nifty_error_modinit _error_modinit;

#endif /* end of header file */
