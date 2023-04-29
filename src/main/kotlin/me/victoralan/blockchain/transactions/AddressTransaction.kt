package me.victoralan.blockchain.transactions

import me.victoralan.blockchain.Hash
import me.victoralan.crypto.SHA3
import me.victoralan.crypto.encoder.Base58
import me.victoralan.software.wallet.Address

class AddressTransaction(
    var address: Address,
    override var time: Long = System.nanoTime()) : Transaction {

    override lateinit var hash: Hash
    init {
        hash = calculateHash()
    }
    override fun calculateHash(): Hash {
        return Hash(SHA3.hashString("${address.publicKey} ${address.address} $time"))
    }

    override fun toString(): String {
        return "AddressTransaction(publicKey=${Base58.encode(address.publicKey.encoded)}, address=${address.address}, time=$time)"
    }
}