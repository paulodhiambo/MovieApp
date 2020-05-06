package com.odhiambopaul.movie.util

import java.io.IOException

class NoInternetException(message: String) : IOException(message)
class ApiException(message: String) : IOException(message)