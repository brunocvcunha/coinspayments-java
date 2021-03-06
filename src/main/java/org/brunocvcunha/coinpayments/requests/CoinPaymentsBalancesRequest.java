/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments.requests;

import java.util.Map;

import org.brunocvcunha.coinpayments.model.BalanceResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

/**
 * Balance Request
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Data
@Builder
public class CoinPaymentsBalancesRequest extends CoinPaymentsPostRequest<ResponseWrapper<Map<String, BalanceResponse>>> {
	
	private boolean ifAll = false;

	@Override
	public String getUrl() {
		return "";
	}
	
    
    @Override
    @SneakyThrows
    public String getPayload() {
        return "cmd=balances&all=" + (ifAll ? "1" : "0");
    }

	@Override
	public ResponseWrapper<Map<String, BalanceResponse>> parseResult(int resultCode, String content) {
		System.out.println(content);
        ResponseWrapper<Map<String, BalanceResponse>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<Map<String, BalanceResponse>>>() {});
        return wrapper;
	}

}
