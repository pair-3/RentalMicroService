package com.appsdevelopersblog.rentacar.api.user.business.abstracts;

import com.appsdevelopersblog.rentacar.api.user.business.requests.UserRequests.LoginUserRequest;
import com.appsdevelopersblog.rentacar.api.user.core.utilities.results.Result;

public interface UserService {
	Result login(LoginUserRequest loginUserRequest);
	Result isUserExists(String userId);
	Result isUserEmailExists(String email);

}
